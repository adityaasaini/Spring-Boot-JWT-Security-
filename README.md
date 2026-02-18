SpringBoot JWT Security 🔐

A production-ready implementation of JWT-based Authentication & Authorization using Spring Boot and Spring Security.

This project demonstrates secure, scalable, and stateless API protection following modern industry standards used in enterprise-grade backend systems.

🚀 Core Features
🔐 Stateless Authentication

Implements token-based authentication to eliminate server-side session storage and improve scalability.

👥 Role-Based Access Control (RBAC)

Fine-grained endpoint protection using roles such as ADMIN and MEMBER.

🛡️ Custom JWT Filter

A custom JwtFilter that intercepts every incoming HTTP request, validates tokens, and establishes authentication context.

🧾 Token Lifecycle Management

Dedicated JwtGenerator for:

Secure token generation

Signature verification

Claims extraction

Expiration handling

🔒 Secure Password Storage

Uses BCryptPasswordEncoder to hash and secure user credentials with salted encryption.

🛠️ Technology Stack
Layer	Technology
Language	Java 17+
Framework	Spring Boot 3.x
Security	Spring Security
JWT Library	JJWT
Build Tool	Maven
API Testing	Postman
📂 Project Structure
src/main/java/com/example/security
│
├── JwtGenerator.java      // Token creation & validation logic
├── JwtFilter.java         // Custom security filter
├── MySecurityConfig.java  // Security configuration & filter chain
├── MyController.java      // Secured REST endpoints
└── UserService.java       // Authentication logic

🔄 Authentication Flow

User sends credentials to /test/login

Server authenticates using Spring Security

JWT is generated and returned

Client sends token in header:

Authorization: Bearer <token>


JwtFilter validates token before granting access

⚙️ Setup & Installation
1️⃣ Clone Repository
git clone https://github.com/adityaasaini/SpringBoot-JWT-Security.git

2️⃣ Configure Secret Key

Update the signing key in JwtGenerator.java with a secure 512-bit Base64-encoded string.

3️⃣ Run Application

Launch as a Spring Boot Application.

🧪 API Testing
🔑 Login
POST /test/login


Request Body

{
  "username": "admin",
  "password": "admin123"
}

📌 Access Protected Endpoint
GET /test/admin
Header:
Authorization: Bearer <your_token>

🏗️ Security Best Practices Implemented

Stateless Session Management

Custom Authentication Entry Point

Secure Password Hashing

Role-based endpoint restriction

Centralized Security Configuration

Clean layered architecture

📌 Future Enhancements

Refresh Token Implementation

Token Blacklisting

OAuth2 Integration

Database-based user management

Rate limiting & API throttling
