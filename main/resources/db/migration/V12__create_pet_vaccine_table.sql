CREATE TABLE PETS_VACCINES (
                       pet_id BIGINT,
                       pet_name VARCHAR(255) NOT NULL,
                       vaccines_id BIGINT,
                       vaccine_name VARCHAR(255) NOT NULL,
                       PRIMARY KEY (pet_id,vaccines_id),
                       FOREIGN KEY (pet_id) REFERENCES PETS(id),
                       FOREIGN KEY (vaccines_id) REFERENCES VACCINES(id)

);


INSERT INTO PETS_VACCINES (pet_id,pet_name, vaccines_id, vaccine_name)
SELECT p.id AS pet_id,p.name AS pet_name, v.id AS vaccines_id, v.name AS vaccine_name
FROM PETS p
         JOIN VACCINES V ON p.info_id = v.info_id;
