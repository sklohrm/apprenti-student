DROP DATABASE IF EXISTS memories;

CREATE DATABASE memories;

USE memories;

CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    password_aes VARBINARY(256) NOT NULL
);

CREATE TABLE memory (
    memory_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id_created INT,
    date_time_created DATETIME NOT NULL,
    memory_text VARCHAR(100) NOT NULL,
    is_public BIT,
    FOREIGN KEY (user_id_created) REFERENCES user(user_id)
);


-- Insert 5 sample users
INSERT INTO user (user_name, password_aes) VALUES
    ('Alice', AES_ENCRYPT('password123', 'carrot')),
    ('Bob', AES_ENCRYPT('securepass', 'carrot')),
    ('Charlie', AES_ENCRYPT('charliepwd', 'carrot')),
    ('Diana', AES_ENCRYPT('dianapass', 'carrot')),
    ('Ethan', AES_ENCRYPT('ethansecret', 'carrot'));

-- Alice (user_id = 1) - 2 Memories
INSERT INTO memory (user_id_created, date_time_created, memory_text, is_public) VALUES
    (1, '2023-10-01 10:00:00', 'First day at the new job, very exciting!', 1),
    (1, '2023-10-05 15:30:00', 'Finished reading "The Great Gatsby".', 0);

-- Bob (user_id = 2) - 2 Memories
INSERT INTO memory (user_id_created, date_time_created, memory_text, is_public) VALUES
    (2, '2023-10-02 08:45:00', 'Ran 5k this morning, new personal best!', 1),
    (2, '2023-10-07 19:00:00', 'Tried a new Thai restaurant tonight. Delicious!', 1);

-- Charlie (user_id = 3) - 2 Memories
INSERT INTO memory (user_id_created, date_time_created, memory_text, is_public) VALUES
    (3, '2023-09-28 12:00:00', 'Landed the big client contract!', 0),
    (3, '2023-10-04 14:00:00', 'Started learning guitar. Tough but fun.', 0);

-- Diana (user_id = 4) - 2 Memories
INSERT INTO memory (user_id_created, date_time_created, memory_text, is_public) VALUES
    (4, '2023-10-03 21:00:00', 'Watched a beautiful sunset from the mountain peak.', 1),
    (4, '2023-10-08 09:15:00', 'Attended a fascinating lecture on astrophysics.', 1);

-- Ethan (user_id = 5) - 2 Memories
INSERT INTO memory (user_id_created, date_time_created, memory_text, is_public) VALUES
    (5, '2023-10-06 17:00:00', 'Baked a perfect loaf of sourdough bread today.', 0),
    (5, '2023-10-09 11:30:00', 'Upgraded my computer RAM. Much faster now.', 0);

SELECT
    memory.memory_id,
    user.user_name,
    memory.date_time_created,
    memory.memory_text,
    memory.is_public
FROM memory
INNER JOIN user ON memory.user_id_created = user.user_id;

INSERT INTO memory (user_id_created, date_time_created, memory_text, is_public) VALUES (?, ?, ?, ?);