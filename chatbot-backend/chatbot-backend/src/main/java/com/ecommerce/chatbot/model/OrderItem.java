package com.ecommerce.chatbot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "inventory_item_id")
    private Long inventoryItemId;

    private String status;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "shipped_at")
    private Timestamp shippedAt;

    @Column(name = "delivered_at")
    private Timestamp deliveredAt;

    @Column(name = "returned_at")
    private Timestamp returnedAt;
}
