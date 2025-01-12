INSERT INTO users (login, password, role) 
VALUES ('admin_user', '$2a$12$Ae2CPdGfML9hooBXAGPyM.xOmjBd7W2jx1mnTQI0BZKkTkAAT5bXa', 'ADMIN')
ON CONFLICT (login) DO NOTHING;