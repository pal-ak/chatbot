package com.ecommerce.chatbot.repository;

import com.ecommerce.chatbot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
