CREATE TABLE IF NOT EXISTS INFO
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    weight DOUBLE NOT NULL,
    age INT,
    gender VARCHAR(255) NOT NULL ,
    appearance VARCHAR(1000),
    med_History VARCHAR(1000),
    is_Healthy BOOLEAN,
    vaccines_list_id BIGINT,
    pet_id BIGINT

);

CREATE SEQUENCE info_seq
    START WITH 1
    INCREMENT BY 50
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;




