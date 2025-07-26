import React from 'react';
import { useChatContext } from '../state/ChatContext';

const ConversationPanel = () => {
  const { conversations, selectConversation, selectedConversation } = useChatContext();

  return (
    <div className="w-64 border-r p-4 overflow-y-auto">
      <h2 className="text-lg font-semibold mb-4">Conversations</h2>
      {conversations.map((conv) => (
        <div
          key={conv.id}
          className={`cursor-pointer p-2 rounded ${selectedConversation === conv.id ? 'bg-blue-200' : 'hover:bg-gray-100'}`}
          onClick={() => selectConversation(conv.id)}
        >
          {conv.title || `Conversation ${conv.id}`}
        </div>
      ))}
    </div>
  );
};

export default ConversationPanel;
