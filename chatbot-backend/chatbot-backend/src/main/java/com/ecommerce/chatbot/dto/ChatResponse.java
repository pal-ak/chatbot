package com.ecommerce.chatbot.dto;

import lombok.Data;

@Data
public class ChatResponse {
    private Long conversationId;
    private String aiResponse;
}
