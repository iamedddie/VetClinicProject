-- Insert entries for cat vaccines
INSERT INTO VACCINES (name, target_disease, means_of_admin, target_animal,info_id)
VALUES
    ('Rabies Vaccine for Cats', 'Rabies', 'Injection', 'CAT',1),
    ('Feline Calicivirus Vaccine', 'Feline Calicivirus', 'Injection', 'CAT',2),
    ('Feline Panleukopenia Vaccine', 'Feline Panleukopenia', 'Injection', 'CAT',2),
    ('Feline Leukemia Vaccine', 'Feline Leukemia', 'Injection', 'CAT',3),
    ('Feline Immunodeficiency Virus Vaccine', 'Feline Immunodeficiency Virus', 'Injection', 'CAT',3);

-- Insert entries for dog vaccines
INSERT INTO VACCINES (name, target_disease, means_of_admin, target_animal,info_id)
VALUES
    ('Rabies Vaccine for Dogs', 'Rabies', 'Injection', 'DOG',6),
    ('Canine Distemper Vaccine', 'Canine Distemper', 'Injection', 'DOG',6),
    ('Canine Parvovirus Vaccine', 'Canine Parvovirus', 'Injection', 'DOG',9),
    ('Canine Adenovirus Type 2 Vaccine', 'Canine Adenovirus Type 2', 'Injection', 'DOG',8),
    ('Canine Parainfluenza Vaccine', 'Canine Parainfluenza', 'Injection', 'DOG',8);
