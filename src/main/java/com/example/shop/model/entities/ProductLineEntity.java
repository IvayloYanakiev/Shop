package com.example.shop.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_lines")
public class ProductLineEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long productId;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    OrderEntity order;
}
