import React from 'react';

const Message = ({ message }) => {
  return (
    <div className={`p-2 rounded ${message.role === 'user' ? 'bg-blue-100' : 'bg-gray-100'}`}>
      <strong>{message.role === 'user' ? 'You' : 'AI'}:</strong> {message.content}
    </div>
  );
};

export default Message;

