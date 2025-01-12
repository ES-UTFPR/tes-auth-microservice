# Authentication API

This document provides details about de REST API endpoints available in the Auth microservice for authenticate actions.

## Base URL

All endpoints are prefixed with `/auth`.

---

## Endpoints

### 1. **Login**

**POST** `/login`

Authenticates an user and returns a JWT token.

#### Request Body:

```json
{
  "login": "string",
  "password": "string"
}
```
#### Responses:

- **200 OK**: User authenticated successfully.
```json
{
  "token": "string"
}
```
- **401 Unauthorized**: Invalid Credentials.
---
### 2. **Register**

**POST** `/register`

Registers a new user in the system.

#### Request Body:

```json
{
  "login": "string",
  "password": "string"
}
```
#### Responses:

- **201 Created**: User created successfully.
- **400 Bad Request**: The login is already in use.