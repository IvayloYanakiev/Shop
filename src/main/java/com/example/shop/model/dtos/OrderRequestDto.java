package com.example.shop.model.dtos;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {

    private List<ProductLineDto> productLines;

}
