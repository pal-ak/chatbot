package com.ecommerce.chatbot.dto;

import lombok.Data;

@Data
public class ChatRequest {
    private String message;
    private Long conversationId; // optional
}
