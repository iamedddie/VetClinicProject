CREATE TABLE IF NOT EXISTS OWNERS
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact VARCHAR(255),
    email VARCHAR(255),
    pets_list_id INT
);

CREATE SEQUENCE owner_seq
    START WITH 1
    INCREMENT BY 50
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;



