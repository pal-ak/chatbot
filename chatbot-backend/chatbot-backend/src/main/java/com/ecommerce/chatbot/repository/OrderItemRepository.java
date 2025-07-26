package com.ecommerce.chatbot.repository;

import com.ecommerce.chatbot.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
