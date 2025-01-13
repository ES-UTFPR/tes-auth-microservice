CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS users (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role INTEGER NOT NULL
);

INSERT INTO users (login, email, password, role) 
VALUES ('admin_user', 'admin@email.com', '$2a$12$Ae2CPdGfML9hooBXAGPyM.xOmjBd7W2jx1mnTQI0BZKkTkAAT5bXa', 0);