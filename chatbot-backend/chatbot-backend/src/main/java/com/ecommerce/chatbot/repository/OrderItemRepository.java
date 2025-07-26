package com.ecommerce.chatbot.repository;

import com.ecommerce.chatbot.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query("""
    SELECT p.name, COUNT(oi.id) 
    FROM OrderItem oi 
    JOIN Product p ON oi.productId = p.id 
    GROUP BY p.name 
    ORDER BY COUNT(oi.id) DESC 
    LIMIT 5
""")
    List<Object[]> findTop5ProductsBySales();

    @Query("SELECT o.status FROM Order o WHERE o.id = :orderId")
    Optional<String> findOrderStatusById(@Param("orderId") Long orderId);

}
