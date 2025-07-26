package com.ecommerce.chatbot.repository;

import com.ecommerce.chatbot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
