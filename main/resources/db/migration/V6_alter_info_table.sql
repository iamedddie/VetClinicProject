

INSERT INTO INFO (pet_id)
SELECT p.id AS pet_id
FROM PETS p
         JOIN INFO i ON p.id = i.pet_id;