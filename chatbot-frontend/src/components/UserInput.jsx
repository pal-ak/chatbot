
import React, { useState } from 'react';
import { useChatContext } from '../state/ChatContext';

const UserInput = ({ conversationId }) => {
  const [input, setInput] = useState('');
  const { sendMessage, loading } = useChatContext();

  const handleSend = async () => {
    if (!input.trim()) return;
    await sendMessage(input, conversationId);
    setInput('');
  };

  return (
    <div className="flex">
      <input
        className="flex-1 border rounded p-2"
        value={input}
        onChange={(e) => setInput(e.target.value)}
        placeholder="Type your message..."
      />
      <button onClick={handleSend} disabled={loading} className="ml-2 px-4 py-2 bg-blue-500 text-white rounded">
        {loading ? '...' : 'Send'}
      </button>
    </div>
  );
};

export default UserInput;