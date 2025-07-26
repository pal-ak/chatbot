package com.ecommerce.chatbot.repository;

import com.ecommerce.chatbot.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {}
