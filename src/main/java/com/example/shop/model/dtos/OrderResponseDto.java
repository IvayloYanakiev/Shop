package com.example.shop.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderResponseDto extends AbstractProductDto{
    private Long outOfStockQuantity;
}
