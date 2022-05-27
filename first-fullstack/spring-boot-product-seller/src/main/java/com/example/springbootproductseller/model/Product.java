package com.example.springbootproductseller.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="create_time", nullable = false)
    private LocalDateTime createTime;

    // bi-directional ~ we can access the purchase list
    // ONE product to MANY purcahses...
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    // private Set<Purchase> purchaseList;
}
