CREATE TABLE IF NOT EXISTS PETS
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    species VARCHAR(255),
    breed VARCHAR(255),
    info_id BIGINT,
    owner_id BIGINT,
    FOREIGN KEY (info_id) REFERENCES INFO(ID)

);

CREATE SEQUENCE pet_seq
    START WITH 1
    INCREMENT BY 50
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;





