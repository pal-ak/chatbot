package com.ecommerce.chatbot.controller;

import com.ecommerce.chatbot.dto.ChatRequest;
import com.ecommerce.chatbot.dto.ChatResponse;
import com.ecommerce.chatbot.model.Conversation;
import com.ecommerce.chatbot.model.Message;
import com.ecommerce.chatbot.repository.ConversationRepository;
import com.ecommerce.chatbot.repository.MessageRepository;
import com.ecommerce.chatbot.service.GroqLLMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatBotService chatBotService;

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        Conversation conversation;

        if (request.getConversationId() != null) {
            conversation = conversationRepository.findById(request.getConversationId())
                    .orElseGet(() -> conversationRepository.save(new Conversation()));
        } else {
            conversation = conversationRepository.save(new Conversation());
        }

        // Save user message
        Message userMessage = new Message();
        userMessage.setSender("user");
        userMessage.setContent(request.getMessage());
        userMessage.setConversation(conversation);
        messageRepository.save(userMessage);

        // Call LLM (Groq)
        String aiReply = groqService.getLLMResponse(conversation.getId());

        // Save AI message
        Message aiMessage = new Message();
        aiMessage.setSender("ai");
        aiMessage.setContent(aiReply);
        aiMessage.setConversation(conversation);
        messageRepository.save(aiMessage);

        // Return response
        ChatResponse response = new ChatResponse();
        response.setConversationId(conversation.getId());
        response.setAiResponse(aiReply);
        return response;
    }
}
