package com.ecommerce.chatbot.repository;

import com.ecommerce.chatbot.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    @Query("SELECT COUNT(i) FROM InventoryItem i WHERE i.productName = :productName AND i.soldAt IS NULL")
    Long countAvailableInventoryByProductName(@Param("productName") String productName);

}
