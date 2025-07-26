import React from 'react';
import MessageList from './MessageList';
import UserInput from './UserInput';
import ConversationPanel from './ConversationPanel';
import { useChatContext } from '../state/ChatContext';

const ChatWindow = () => {
  const { selectedConversation } = useChatContext();

  return (
    <div className="flex h-screen">
      <ConversationPanel />
      <div className="flex flex-col flex-1 p-4">
        <div className="flex-1 overflow-y-auto">
          <MessageList conversationId={selectedConversation} />
        </div>
        <UserInput conversationId={selectedConversation} />
      </div>
    </div>
  );
};

export default ChatWindow;