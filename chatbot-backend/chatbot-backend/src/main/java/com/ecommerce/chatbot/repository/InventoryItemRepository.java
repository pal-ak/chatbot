package com.ecommerce.chatbot.repository;

import com.ecommerce.chatbot.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
}
