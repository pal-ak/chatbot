package com.ecommerce.chatbot.service;

import com.ecommerce.chatbot.model.Message;
import com.ecommerce.chatbot.repository.InventoryItemRepository;
import com.ecommerce.chatbot.repository.OrderItemRepository;
import com.ecommerce.chatbot.repository.ProductRepository;
import com.ecommerce.chatbot.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatBotService {

    private final ProductRepository productRepo;
    private final InventoryItemRepository inventoryRepo;
    private final OrderItemRepository orderItemRepo;
    private final MessageRepository messageRepo;
    private final GroqLLMService groqService;

    public ChatBotService(ProductRepository productRepo,
                          InventoryItemRepository inventoryRepo,
                          OrderItemRepository orderItemRepo,
                          MessageRepository messageRepo,
                          GroqLLMService groqService) {
        this.productRepo = productRepo;
        this.inventoryRepo = inventoryRepo;
        this.orderItemRepo = orderItemRepo;
        this.messageRepo = messageRepo;
        this.groqService = groqService;
    }

    public String handleUserMessage(Long conversationId, String userMessage) {
        userMessage = userMessage.toLowerCase();

        try {
            if (userMessage.contains("top 5 most sold")) {
                return getTop5SoldProducts();
            } else if (userMessage.matches(".*status of order.*\\d+.*")) {
                Long orderId = extractOrderId(userMessage);
                return getOrderStatus(orderId);
            } else if (userMessage.matches(".*how many.*classic t-?shirt.*in stock.*")) {
