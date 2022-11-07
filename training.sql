SELECT client.nom,
    article.nom,
    ligne_achat.quantite,
    article.prix,
    ligne_achat.quantite * article.prix as sous_total
FROM article,
    ligne_achat,
    client,
    facture
WHERE client.nom = "Enguerrand"
    and article.id = ligne_achat.idarticle
    and facture.idclient = client.id
    and ligne_achat.idfacture = facture.id;
-- 03/11/2022
CREATE DATABASE zoo;
USE zoo;
CREATE TABLE food (
    id INTEGER primary key auto_increment not null,
    name VARCHAR(255)
);
CREATE TABLE species (
    id INTEGER primary key auto_increment not null,
    name VARCHAR(255)
);
CREATE TABLE animal (
    id INTEGER primary key auto_increment not null,
    name VARCHAR(255),
    id_species INTEGER not null,
    FOREIGN KEY (id_species) REFERENCES species(id)
);
CREATE TABLE country (
    id INTEGER primary key auto_increment not null,
    name VARCHAR(255)
);
CREATE TABLE animal_food (
    id INTEGER primary key auto_increment not null,
    id_animal INTEGER,
    id_food INTEGER,
    favourite INTEGER,
    FOREIGN KEY (id_animal) REFERENCES animal(id),
    FOREIGN KEY (id_food) REFERENCES food(id)
);
CREATE TABLE animal_country (
    id INTEGER primary key auto_increment not null,
    id_animal INTEGER,
    id_country INTEGER,
    FOREIGN KEY (id_animal) REFERENCES animal(id),
    FOREIGN KEY (id_country) REFERENCES country(id)
);
INSERT INTO species (name)
VALUES ('mammal'),
    ('insect'),
    ('reptile'),
    ('fish'),
    ('amphibien'),
    ('bird');
INSERT INTO food (name)
VALUES ('meat'),
    ('grass'),
    ('seeds'),
    ('fish'),
    ('croquette'),
    ('fruit'),
    ('vers'),
    ('insect'),
    ('ant');
INSERT INTO country (name)
VALUES ('france'),
    ('england'),
    ('australia'),
    ('india'),
    ('china'),
    ('congo'),
    ('italy'),
    ('spain'),
    ('south africa'),
    ('brasil'),
    ('US');
INSERT INTO animal (name, id_species)
VALUES ('cat', 1),
    ('pig', 1),
    ('blackbird', 6),
    ('crow', 6),
    ('carp', 4),
    ('pangolin', 1),
    ('pirhana', 4),
    ('python', 3),
    ('peafowl', 6),
    ('cameleon', 3),
    ('cicadas', 2),
    ('ant', 2),
    ('mouse', 1),
    ('anteater', 1),
    ('platypus', 1),
    ('dog', 1),
    ('squirrel', 1);
INSERT INTO animal_country (id_animal, id_country)
VALUES (1, 1),
    (2, 2),
    (3, 2),
    (4, 3),
    (5, 5),
    (6, 5),
    (7, 10),
    (8, 3),
    (9, 1),
    (10, 10),
    (11, 1),
    (12, 10),
    (13, 1),
    (14, 9),
    (15, 3),
    (16, 2),
    (17, 1);
INSERT INTO animal_food (id_animal, id_food, favourite)
VALUES (1, 5, 10),
    (2, 1, 10),
    (2, 3, 9),
    (2, 4, 6),
    (2, 5, 7),
    (2, 7, 4),
    (2, 8, 3),
    (3, 3, 10),
    (4, 3, 10),
    (5, 4, 10),
    (6, 2, 10),
    (7, 1, 10),
    (8, 1, 10),
    (9, 1, 10),
    (10, 3, 10),
    (11, 8, 10),
    (12, 2, 10),
    (13, 3, 10),
    (14, 9, 10),
    (15, 4, 10),
    (16, 5, 10),
    (17, 3, 10);
-- SELECT animal.name as animal,
--     species.name as species
-- FROM animal,
--     species
-- WHERE species.id = animal.id_species;

-- 
SELECT food.name as food,
    animal.name as animal
FROM food,
    animal,
    animal_food
where animal_food.id_animal = animal.id
    and animal_food.id_food = food.id;
-- same with join
SELECT food.name as food,
    animal.name as animal
FROM animal_food
    JOIN animal ON animal_food.id_animal = animal.id
    JOIN food ON animal_food.id_food = food.id;
-- now includes unassociated animals
SELECT food.name as food,
    animal.name as animal
FROM animal
    LEFT JOIN animal_food ON animal.id = animal_food.id_animal
    LEFT JOIN food on food.id = animal_food.id_food;
-- now with species
SELECT food.name as food,
    animal.name as animal,
    species.name as species,
    country.name as country
FROM animal
    LEFT JOIN animal_food ON animal.id = animal_food.id_animal
    LEFT JOIN food on food.id = animal_food.id_food
    LEFT JOIN species ON species.id = animal.id_species
    LEFT JOIN animal_country ON animal.id = animal_country.id_animal
    LEFT JOIN country on country.id = animal_country.id_country;
-- now with species group by
SELECT food.name as food,
    animal.name as animal,
    species.name as species,
    country.name as country,
    animal_food.favourite as preference
FROM animal
    LEFT JOIN animal_food ON animal.id = animal_food.id_animal
    LEFT JOIN food on food.id = animal_food.id_food
    LEFT JOIN species ON species.id = animal.id_species
    LEFT JOIN animal_country ON animal.id = animal_country.id_animal
    LEFT JOIN country on country.id = animal_country.id_country
WHERE animal_food.favourite<8;