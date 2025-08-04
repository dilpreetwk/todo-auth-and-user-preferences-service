# Local MySQL setup
```sql
CREATE DATABASE todo_auth;
CREATE USER 'dbmaster'@'%' IDENTIFIED BY 'qwerty123';
GRANT ALL PRIVILEGES ON todo_auth.* TO 'dbmaster'@'%';
FLUSH PRIVILEGES;
```