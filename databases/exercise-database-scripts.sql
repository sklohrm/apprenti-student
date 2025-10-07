DROP DATABASE IF EXISTS movie_db;
CREATE DATABASE movie_db;
USE movie_db;

-- 1. Create a basic database schema for tracking movies and actors.

CREATE TABLE Actor (
    actor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE,
    UNIQUE (first_name, last_name)
);

CREATE TABLE Movie (
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    release_year YEAR NOT NULL,
    rating VARCHAR(10),
    UNIQUE (title, release_year)
);

-- Relationship between movies and actors.
CREATE TABLE Credit (
    credit_id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT NOT NULL,
    actor_id INT NOT NULL,
    role_name VARCHAR(100) NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES Movie(movie_id)
                    ON DELETE CASCADE,
    FOREIGN KEY (actor_id) REFERENCES Actor(actor_id)
        ON DELETE CASCADE,
    UNIQUE (movie_id, actor_id, role_name)
);

-- 2. Enhance the schema to add genres.

-- Table of unique genres.
CREATE TABLE Genre (
    genre_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Join movies and genres.
CREATE TABLE MovieGenre (
    movie_id INT NOT NULL,
    genre_id INT NOT NULL,
    PRIMARY KEY (movie_id, genre_id),
    FOREIGN KEY (movie_id) REFERENCES Movie(movie_id)
                        ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES Genre(genre_id)
                        ON DELETE CASCADE
);

-- 3. Alter movie table to have Director

CREATE TABLE Director (
    director_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    UNIQUE (first_name, last_name)
);

ALTER TABLE Movie
ADD COLUMN director_id INT,
ADD CONSTRAINT fk_movie_director
    FOREIGN KEY (director_id) REFERENCES Director(director_id)
    ON DELETE SET NULL;
