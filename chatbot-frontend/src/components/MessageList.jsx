import React from 'react';
import Message from './Message';
import { useChatContext } from '../state/ChatContext';

const MessageList = () => {
  const { messages } = useChatContext();

  return (
    <div className="space-y-2">
      {messages.map((msg) => (
        <Message key={msg.id} message={msg} />
      ))}
    </div>
  );
};

export default MessageList;