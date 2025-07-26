package com.ecommerce.chatbot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    private Long id;

    private double cost;
    private String category;
    private String name;
    private String brand;

    @Column(name = "retail_price")
    private double retailPrice;

    private String department;
    private String sku;

    @Column(name = "distribution_center_id")
    private Long distributionCenterId;
}
