package com.example.shop.controller;

import com.example.shop.model.dtos.OrderRequestDto;
import com.example.shop.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //creates new order
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        orderService.createOrder(orderRequestDto);
        return ResponseEntity.ok().body("Order was successfully submited!");
    }
}
