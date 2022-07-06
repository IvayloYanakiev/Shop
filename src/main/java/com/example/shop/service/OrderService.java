package com.example.shop.service;

import com.example.shop.model.dtos.OrderRequestDto;
import com.example.shop.model.entities.OrderEntity;

public interface OrderService {
    OrderEntity createOrder(OrderRequestDto orderRequestDto);
}
