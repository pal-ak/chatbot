project-strcuture:
```
chatbot-support-app/
├── backend/                      # Spring Boot (Java + Gradle)
│   ├── build.gradle
│   ├── settings.gradle
│   ├── Dockerfile
│   └── src/
│       ├── main/
│       │   ├── java/com/ecommerce/chatbot/
│       │   │   ├── controller/       # REST endpoints
│       │   │   ├── service/          # Business logic
│       │   │   ├── repository/       # Spring Data JPA
│       │   │   ├── model/            # JPA entities
│       │   │   ├── chatbot/          # NLP & Query Routing
│       │   │   └── ChatbotBackendApplication.java
│       │   └── resources/
│       │       ├── application.yml
│       │       └── data/             # Optional CSVs for seed/init
│       └── test/                     # Unit/integration tests
│           └── java/com/ecommerce/chatbot/
│               └── service/
├── frontend/                    # React frontend
│   ├── Dockerfile
│   ├── package.json
│   ├── vite.config.js           # or react-scripts config
│   ├── public/
│   └── src/
│       ├── components/
│       ├── pages/
│       ├── services/            # API call helpers
│       ├── App.jsx
│       └── index.js
├── docker-compose.yml           # Dev orchestration (DB + Backend + Frontend)
├── README.md
└── .gitignore
```
