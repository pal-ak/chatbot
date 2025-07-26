import React, { createContext, useContext, useState, useEffect } from 'react';
import axios from 'axios';

const ChatContext = createContext();

export const ChatProvider = ({ children }) => {
  const [messages, setMessages] = useState([]);
  const [loading, setLoading] = useState(false);
  const [conversations, setConversations] = useState([]);
  const [selectedConversation, setSelectedConversation] = useState(null);

  const sendMessage = async (text, conversationId = null) => {
    setLoading(true);
    const response = await axios.post('http://localhost:8080/api/chat', {
      message: text,
      conversationId
    });
    const { conversationId: newConvId, userMessage, aiMessage } = response.data;

    setMessages((prev) => [...prev, userMessage, aiMessage]);
    if (!selectedConversation) setSelectedConversation(newConvId);
    setLoading(false);
    fetchConversations();
  };

  const fetchConversations = async () => {
    const res = await axios.get('http://localhost:8080/api/conversations');
    setConversations(res.data);
  };

  const selectConversation = async (id) => {
    setSelectedConversation(id);
    const res = await axios.get(`http://localhost:8080/api/conversations/${id}`);
    setMessages(res.data.messages);
  };

  useEffect(() => {
    fetchConversations();
  }, []);

  return (
    <ChatContext.Provider value={{ messages, sendMessage, loading, conversations, selectConversation, selectedConversation }}>
      {children}
    </ChatContext.Provider>
  );
};

export const useChatContext = () => useContext(ChatContext);