package com.ecommerce.chatbot.repository;

import com.ecommerce.chatbot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
