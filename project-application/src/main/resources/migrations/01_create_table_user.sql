--liquibase formatted sql

--changeset slorinc:1
CREATE TABLE USER (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR(50) UNIQUE,   -- e-mail address
  name VARCHAR(100) UNIQUE   -- user's full name

);

--rollback DROP TABLE clicks;
