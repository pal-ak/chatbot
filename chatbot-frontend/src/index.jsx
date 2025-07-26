import React from 'react';
import ReactDOM from 'react-dom';
import ChatWindow from './components/ChatWindow';
import { ChatProvider } from './state/ChatContext';
import './index.css';

ReactDOM.render(
  <ChatProvider>
    <ChatWindow />
  </ChatProvider>,
  document.getElementById('root')
);
