🔐 Spring Boot JWT Authentication System

A secure REST API built using Spring Boot and Spring Security implementing JWT (JSON Web Token) based authentication and authorization.
This project follows clean layered architecture and demonstrates real-world backend security implementation used in modern web applications.
---
🚀 Features
Authentication

Secure Login API

JWT Token Generation

Stateless Session Management

Authorization

Role-Based Access Control (ADMIN / MEMBER)

Protected Endpoints

Custom JWT Filter for request validation

Security

Password encryption using BCrypt

Token expiration handling

Secure filter chain configuration

---
🧱 Architecture

The project follows a layered architecture:

Controller Layer – REST endpoints and request handling

Service Layer – Business logic and authentication flow

Security Layer – JWT filter, token validation, and security configuration

DAO / Repository Layer – User data handling

Utility Layer – Token generation and parsing

🛠 Tech Stack

Java 17+

Spring Boot 3.x

Spring Security

JJWT Library

Maven

Postman

---
📂 Project Structure
src/main/java/com/security
├── controller
├── service
├── repository
├── security
├── util
└── model

---
⚙️ How to Run the Project

Clone the repository

Configure application.properties with your settings

Update JWT secret key inside JwtGenerator

Run the application as Spring Boot App

---
🧪 API Testing

POST /test/login → Generate JWT Token

Add Header:
Authorization: Bearer <token>

Access protected endpoints

---
🎯 Learning Outcomes

Understanding stateless authentication

Implementing JWT security in Spring Boot

Configuring Spring Security filter chain

Role-based endpoint protection

Secure password hashing

---
📌 Future Enhancements

Refresh Token Implementation

Database-based User Management

Token Blacklisting

OAuth2 Integration

Deployment on AWS
