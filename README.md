# 🧠 Chatbot Application (Spring Boot + React + PostgreSQL + Groq API)

This is a full-stack chatbot app that:
- Accepts user messages
- Sends them to Groq's LLM API
- Stores conversation history in PostgreSQL
- Supports a React-based frontend with full conversation viewing and state management

---

## 🧱 Tech Stack

### ✅ Backend
- Java 17
- Spring Boot
- PostgreSQL
- Gradle
- Groq API integration

### ✅ Frontend
- React (Vite or CRA)
- Context API (for state management)
- Axios

### ✅ Infrastructure
- Docker & Docker Compose

---

## 🚀 Features

- Chat with an AI assistant via Groq API
- Persistent conversation storage
- View past sessions in a sidebar
- Rehydrate old conversations
- Fully dockerized development environment

---

## 📦 Project Structure
```
chatbot/
├── chatbot-backend/ # Spring Boot backend
│ ├── src/main/java/com/example/chatbot/
│ │ ├── controller/
│ │ │ └── ChatController.java
│ │ ├── model/
│ │ │ └── Conversation.java, Message.java
│ │ ├── repository/
│ │ │ └── ConversationRepository.java, MessageRepository.java
│ │ └── service/
│ │ └── ChatService.java
│ └── resources/
│ └── application.properties
│
├── chatbot-frontend/ # React frontend
│ ├── src/components/
│ │ ├── ChatWindow.jsx
│ │ ├── ConversationPanel.jsx
│ │ ├── MessageList.jsx
│ │ ├── Message.jsx
│ │ └── UserInput.jsx
│ ├── src/context/ChatContext.js
│ ├── src/App.jsx
│ └── index.js
│
├── docker-compose.yml
├── Dockerfile.backend
├── Dockerfile.frontend
└── README.md
```
## 🧪 Local Setup

### 1. Clone the repo
```bash
git clone https://github.com/your-username/chatbot.git
cd chatbot
```
### 2. Setup Environment
#### Backend
```bash
cd chatbot-backend
cp src/main/resources/application.properties.example src/main/resources/application.properties
```
Set your actual DB and Groq API key values in application.properties.

#### Frontend
```bash
cd ../chatbot-frontend
npm install
```
### 3. Start Services Locally (without Docker)
#### Backend
```bash
./gradlew bootRun
```
#### Frontend
```bash
npm run dev
```
Ensure PostgreSQL is running at localhost:5432 with a DB named ecommerce.

### 🐳 Dockerized Setup
#### Build and Start All Services
```bash
docker-compose up --build
```

### 🔐 Environment Variables
#### Set this in application.properties:
```
groq.api.key=${GROQ_API_KEY}
```

### 📬 API Reference
#### POST /api/chat
```json
Request:
{
  "message": "Tell me about Java",
  "conversationId": 1 // optional
}

Response:
{
  "conversationId": 1,
  "messages": [
    { "sender": "USER", "text": "Tell me about Java" },
    { "sender": "AI", "text": "Java is a high-level programming language..." }
  ]
}
```

### ✅ Milestone Checklist
 -Backend: DB + Entity + Repos + Service

 -REST API /api/chat

 -Groq LLM integration

 -React UI: ChatWindow, MessageList, UserInput, ConversationPanel

 -State Management (Context API)

 -View conversation history

 -Full Dockerization

 -Readme written
