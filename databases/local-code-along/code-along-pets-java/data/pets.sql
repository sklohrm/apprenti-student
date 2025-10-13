DROP DATABASE IF EXISTS pets;

CREATE DATABASE pets;

USE pets;

CREATE TABLE pet (
    pet_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `type` VARCHAR(50) NULL
) AUTO_INCREMENT = 101;

INSERT INTO pet (`name`, `type`)
VALUES
    ('Meep', 'Mouse'),
    ('Slithers', 'Snake'),
    ('Noodles', 'Dog'),
    ('Chloe', 'Cat');

SELECT pet_id, `name`, `type` FROM pet;