package com.example.shop.service.impl;

import com.example.shop.model.dtos.OrderRequestDto;
import com.example.shop.model.dtos.ProductLineDto;
import com.example.shop.model.entities.OrderEntity;
import com.example.shop.model.entities.ProductLineEntity;
import com.example.shop.repository.OrderRepository;
import com.example.shop.service.OrderService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final KafKaProducerServiceImpl kafKaProducerServiceImpl;

    public OrderServiceImpl(OrderRepository orderRepository, KafKaProducerServiceImpl kafKaProducerServiceImpl) {
        this.orderRepository = orderRepository;
        this.kafKaProducerServiceImpl = kafKaProducerServiceImpl;
    }

    @Override
    public OrderEntity createOrder(OrderRequestDto orderRequestDto) {
        //TODO: create mapper
        OrderEntity order = new OrderEntity();
        LinkedList<ProductLineEntity> orderProductLines = new LinkedList<>();
        orderRequestDto.getProductLines().forEach(dto -> constructProductLineEntity(orderProductLines, dto));
        order.setProductLines(orderProductLines);
        OrderEntity orderEntity = orderRepository.save(order);

        //sends message to kafka
        kafKaProducerServiceImpl.sendMessage(new Gson().toJson(orderEntity));

        return orderEntity;
    }

    private void constructProductLineEntity(LinkedList<ProductLineEntity> orderProductLines, ProductLineDto dto) {
        ProductLineEntity entity = new ProductLineEntity();
        entity.setProductId(dto.getProductId());
        entity.setQuantity(dto.getQuantity());
        orderProductLines.add(entity);
    }
}
