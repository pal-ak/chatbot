package com.ecommerce.chatbot.repository;

import com.ecommerce.chatbot.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {}
