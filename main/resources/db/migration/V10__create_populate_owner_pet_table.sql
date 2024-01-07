CREATE TABLE IF NOT EXISTS OWNER_PETS (
        owner_id BIGINT NOT NULL,
        owner_name VARCHAR NOT NULL,
        pet_id BIGINT NOT NULL,
        pet_name VARCHAR(255) NOT NULL,
        pet_species VARCHAR(255) NOT NULL,
        PRIMARY KEY (owner_id, pet_id),
        FOREIGN KEY (owner_id) REFERENCES OWNERS(id)
);

INSERT INTO OWNER_PETS (owner_id, owner_name, pet_id, pet_name,pet_species)
SELECT o.id AS owner_id, o.name AS owner_name, p.id AS pet_id, p.name AS pet_name,p.species AS pet_species
FROM OWNERS o
JOIN PETS p ON o.id = p.owner_id;




