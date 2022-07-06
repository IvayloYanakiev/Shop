package com.example.shop.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    List<ProductLineEntity> productLines;
}
