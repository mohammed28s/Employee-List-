# Employee List

Employee List is a full-stack CRUD application for managing employees with a Spring Boot backend and an Angular frontend.

## Stack

- Backend: Spring Boot 4, Spring Web MVC, Spring Data JPA, H2
- Frontend: Angular 21, TypeScript, Bootstrap
- API docs: Springdoc OpenAPI / Swagger UI

## Project Structure

```text
Employee-List-/
├── backend/Employee-List
└── frontend
```

## Features

- View all employees
- Create a new employee
- Update employee details
- Delete an employee
- View employee details
- Swagger UI for backend API inspection

## Prerequisites

- Java 26
- Node.js 22.x or 24.x LTS
- npm
- Maven Wrapper (`./mvnw`) is included

## Run The Project

### 1. Start the backend

```bash
cd backend/Employee-List
./mvnw spring-boot:run
```

Backend defaults:

- API base URL: `http://localhost:8080/api/v1/employees`
- Swagger UI: `http://localhost:8080/docs`
- OpenAPI JSON: `http://localhost:8080/api-docs`
- H2 database: in-memory

### 2. Start the frontend

```bash
cd frontend
npm install
npm start
```

Frontend default URL:

- `http://localhost:4200`

## Development Notes

- The frontend is configured to call the backend on `http://localhost:8080`
- The backend currently uses H2 in-memory storage for local development
- Restarting the backend resets the in-memory data

## Available Scripts

Inside `frontend`:

```bash
npm start
npm run build
npm test
```

Inside `backend/Employee-List`:

```bash
./mvnw spring-boot:run
./mvnw test
```

## API Overview

Base path:

```text
/api/v1/employees
```

Endpoints:

- `GET /api/v1/employees`
- `POST /api/v1/employees`
- `GET /api/v1/employees/{id}`
- `PUT /api/v1/employees/{id}`
- `DELETE /api/v1/employees/{id}`

## Notes For Production

- Replace the H2 configuration with a persistent database such as MySQL or PostgreSQL
- Use a supported LTS Node.js version for Angular development and builds
- Review CORS and environment-specific API URLs before deployment
