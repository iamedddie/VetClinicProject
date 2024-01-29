INSERT INTO PROFILE ( weight, age, gender, appearance, med_History, is_Healthy)
VALUES
    ( 4.5, 3, 'FEMALE', 'Fluffy black fur', 'No major issues', true),
    ( 5.2, 2, 'MALE', 'Striped tabby', 'Vaccinated, no health concerns', true),
    ( 3.8, 4, 'FEMALE', 'White with blue eyes', 'Regular check-ups', true),
    ( 6.1, 5, 'MALE', 'Calico coat', 'Had a previous injury', false),
    ( 4.0, 1, 'FEMALE', 'Tortoiseshell pattern', 'Sensitive to certain foods', true);


INSERT INTO PROFILE ( weight, age, gender, appearance, med_History, is_Healthy)
VALUES
    ( 12.5, 4, 'MALE', 'Golden retriever, medium size', 'Up-to-date vaccinations', true),
    ( 8.3, 6, 'FEMALE', 'Black fur, large breed', 'Hip dysplasia, under medication', false),
    ( 9.7, 2, 'MALE', 'Spotted Dalmatian', 'Healthy, regular exercise', true),
    ( 10.0, 3, 'FEMALE', 'Brown coat, mixed breed', 'Previous surgeries', true),
    ( 7.8, 5, 'MALE', 'Fluffy white, small size', 'Allergic to certain foods', true);


-- Insert entries for cat vaccines
INSERT INTO VACCINES (name, target_disease, means_of_admin, target_animal,profile_id)
VALUES
    ('Rabies Vaccine for Cats', 'Rabies', 'Injection', 'CAT',1),
    ('Feline Calicivirus Vaccine', 'Feline Calicivirus', 'Injection', 'CAT',2),
    ('Feline Panleukopenia Vaccine', 'Feline Panleukopenia', 'Injection', 'CAT',2),
    ('Feline Leukemia Vaccine', 'Feline Leukemia', 'Injection', 'CAT',3),
    ('Feline Immunodeficiency Virus Vaccine', 'Feline Immunodeficiency Virus', 'Injection', 'CAT',3);

-- Insert entries for dog vaccines
INSERT INTO VACCINES (name, target_disease, means_of_admin, target_animal,profile_id)
VALUES
    ('Rabies Vaccine for Dogs', 'Rabies', 'Injection', 'DOG',6),
    ('Canine Distemper Vaccine', 'Canine Distemper', 'Injection', 'DOG',6),
    ('Canine Parvovirus Vaccine', 'Canine Parvovirus', 'Injection', 'DOG',9),
    ('Canine Adenovirus Type 2 Vaccine', 'Canine Adenovirus Type 2', 'Injection', 'DOG',8),
    ('Canine Parainfluenza Vaccine', 'Canine Parainfluenza', 'Injection', 'DOG',8);


-- Insert entries for cats
INSERT INTO PETS (category, name, breed, species,profile_id,owner_id)
VALUES
    ('ADOPTION', 'Fluffy', 'Persian', 'CAT',1,1),
    ('ADOPTION', 'Whiskers', 'Siamese', 'CAT',2,2),
    ('TREATMENT', 'Mittens', 'Tabby', 'CAT',3,3),
    ('ADOPTION', 'Shadow', 'Maine Coon', 'CAT',4,4),
    ('TREATMENT', 'Tiger', 'Bengal', 'CAT',5,5);

-- Insert entries for dogs
INSERT INTO PETS (category, name, breed, species,profile_id,owner_id)
VALUES
    ('ADOPTION', 'Buddy', 'Golden Retriever', 'DOG',6,1),
    ('TREATMENT', 'Max', 'German Shepherd', 'DOG',7,2),
    ('ADOPTION', 'Charlie', 'Labrador Retriever', 'DOG',8,3),
    ('TREATMENT', 'Bella', 'Poodle', 'DOG',9,4),
    ('ADOPTION', 'Lucy', 'Beagle', 'DOG',10,5);

-- Insert entries for cat owners
INSERT INTO OWNERS (contact, name, email)
VALUES
    ('1234567890', 'Alice', 'alice@email.com'),
    ('9876543210', 'Bob', 'bob@email.com'),
    ('1112223334', 'Charlie', 'charlie@email.com'),
    ('5556667777', 'Diana', 'diana@email.com'),
    ('8889990000', 'Emily', 'emily@email.com');

-- Insert entries for dog owners
INSERT INTO OWNERS (contact, name, email)
VALUES
    ('4443332221', 'Frank', 'frank@email.com'),
    ('7778889992', 'Grace', 'grace@email.com'),
    ('1212121212', 'Henry', 'henry@email.com'),
    ('3434343434', 'Isabel', 'isabel@email.com'),
    ('1010101010', 'Jack', 'jack@email.com');


INSERT INTO ENQUIRY (contact, name, email,message)
VALUES
       ('1010101010', 'Jack', 'jack@email.com','Can I adopt two cats ?');



INSERT INTO OWNERS_PETS (owner_id, owner_name, pets_id, pet_name,pet_species)
SELECT o.id AS owner_id, o.name AS owner_name, p.id AS pets_id, p.name AS pet_name,p.species AS pet_species
FROM OWNERS o
         JOIN PETS p ON o.id = p.owner_id;


INSERT INTO PROFILE_VACCINES (profile_id, vaccines_id, vaccine_name)
SELECT i.id AS profile_id, v.id AS vaccines_id, v.name AS vaccine_name
FROM PROFILE i
         JOIN VACCINES V ON i.id = v.profile_id;


INSERT INTO PETS_PROFILE (pet_id,pet_name,profile_id,profile_weight,profile_age,profile_gender,profile_appearance,profile_med_history,profile_is_healthy )
SELECT p.id AS profile_id, p.name AS pet_name, i.id AS profile_id,i.weight AS profile_weight,i.age AS profile_age,i.gender AS profile_gender,
       i.appearance AS profile_appearance, i.med_history AS profile_med_history,i.is_healthy AS profile_is_healthy
FROM PROFILE i
         JOIN PETS p ON i.id = p.profile_id;