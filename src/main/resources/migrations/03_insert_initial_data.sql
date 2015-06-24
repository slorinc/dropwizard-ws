--liquibase formatted sql

--changeset slorinc:3
INSERT INTO USER (name,email) VALUES( 'Lorinc Sonnevend', 'slorinc@gmail.com' );
INSERT INTO USER (name,email) VALUES( 'Ragnar Lodbrok', 'ragnar@gmail.com' );
INSERT INTO USER (name,email) VALUES( 'Björn Ironside', 'bjorn@gmail.com' );

--rollback TRUNCATE TABLE USER;
