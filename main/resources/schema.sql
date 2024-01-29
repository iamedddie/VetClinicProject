
CREATE TABLE IF NOT EXISTS PROFILE (
   id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   weight DOUBLE NOT NULL,
   age INT,
   gender VARCHAR(255) NOT NULL,
   appearance VARCHAR(1000),
   med_History VARCHAR(1000),
   is_Healthy BOOLEAN
);


CREATE TABLE IF NOT EXISTS OWNERS
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact VARCHAR(255),
    email VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS ENQUIRY
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact VARCHAR(255),
    email VARCHAR(255),
    message VARCHAR(1000)
    );



CREATE TABLE IF NOT EXISTS VACCINES
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    target_Disease VARCHAR(255),
    means_of_admin VARCHAR(255),
    target_animal VARCHAR(255),
    profile_id BIGINT
    );


CREATE TABLE IF NOT EXISTS OWNERS_PETS (
    owner_id BIGINT NOT NULL,
    owner_name VARCHAR(255) NOT NULL,
    pets_id BIGINT NOT NULL,
    pet_name VARCHAR(255) NOT NULL,
    pet_species VARCHAR(255) NOT NULL,
    PRIMARY KEY (owner_id, pets_id),
    foreign key (owner_id) references OWNERS(id),
    foreign key (pets_id) references PETS(id)
    );


CREATE TABLE IF NOT EXISTS PROFILE_VACCINES (
    profile_id BIGINT,
    vaccines_id BIGINT,
    vaccine_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (profile_id,vaccines_id),
    foreign key (vaccines_id) references VACCINES(id),
    foreign key (profile_id) references PROFILE(id)

);


CREATE TABLE IF NOT EXISTS PETS_PROFILE (
      pet_id BIGINT,
      pet_name VARCHAR(255) NOT NULL,
      profile_id BIGINT,
      profile_weight DOUBLE,
      profile_age INT,
      profile_gender VARCHAR(255) NOT NULL,
      profile_appearance VARCHAR(1000) NOT NULL,
      profile_med_history VARCHAR(1000) NOT NULL,
      profile_is_healthy VARCHAR(255) NOT NULL,
      PRIMARY KEY (profile_id,pet_id),
      foreign key (pet_id) references PETS(id),
      foreign key (profile_id) references PROFILE(id)

);