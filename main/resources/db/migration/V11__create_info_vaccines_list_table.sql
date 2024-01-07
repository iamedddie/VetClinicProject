CREATE TABLE INFO_VACCINES (
            pet_health_info_id BIGINT,
            vaccines_id BIGINT,
            vaccine_name VARCHAR(255) NOT NULL,
            PRIMARY KEY (pet_health_info_id,vaccines_id),
            FOREIGN KEY (pet_health_info_id) REFERENCES INFO(id),
            FOREIGN KEY (pet_health_info_id) REFERENCES VACCINES(id)

);


INSERT INTO INFO_VACCINES (pet_health_info_id, vaccines_id, vaccine_name)
SELECT i.id AS pet_health_info_id, v.id AS vaccines_id, v.name AS vaccine_name
FROM INFO i
         JOIN VACCINES V ON i.id = v.id;


