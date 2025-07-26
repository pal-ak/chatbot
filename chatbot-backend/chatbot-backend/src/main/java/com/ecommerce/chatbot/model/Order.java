package com.ecommerce.chatbot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    private String status;
    private String gender;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "returned_at")
    private Timestamp returnedAt;

    @Column(name = "shipped_at")
    private Timestamp shippedAt;

    @Column(name = "delivered_at")
    private Timestamp deliveredAt;

    @Column(name = "num_of_item")
    private Integer numOfItem;
}
