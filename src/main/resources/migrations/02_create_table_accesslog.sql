--liquibase formatted sql

--changeset slorinc:2
CREATE TABLE ACCESSLOG (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  userid BIGINT,  -- user.id visited
  visitorid BIGINT,   -- user.id of the visitor
  FOREIGN KEY (userid) REFERENCES USER(id),
  FOREIGN KEY (visitorid) REFERENCES USER(id),
  timestamp DATETIME -- timestamp of the visit
);

--rollback DROP TABLE ACCESSLOG;
