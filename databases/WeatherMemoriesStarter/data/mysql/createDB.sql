drop database if exists memories;

create database memories;

use memories;

create table memory (
    memory_id int primary key auto_increment,
    user_id_created int,
    date_time_created datetime,
    memoryText varchar(100) not null,
    is_public bit,
    averageTemp decimal(4,2)
);

create table user (
                      user_id int primary key auto_increment,
                      user_name varchar(100) not null,
                      password_aes VARBINARY(256) not null
);

-- Insert 5 sample users
INSERT INTO user (user_name, password_aes) VALUES
                                               ('Alice', AES_ENCRYPT('password123', 'carrot')),
                                               ('Bob', AES_ENCRYPT('securepass', 'carrot')),
                                               ('Charlie', AES_ENCRYPT('charliepwd', 'carrot')),
                                               ('Diana', AES_ENCRYPT('dianapass', 'carrot')),
                                               ('Ethan', AES_ENCRYPT('ethansecret', 'carrot'));

-- Alice (user_id = 1) - 2 Memories
INSERT INTO memory (user_id_created, date_time_created, memoryText, is_public, averageTemp) VALUES
                                                                                                (1, '2023-10-01 10:00:00', 'First day at the new job, very exciting!', 1, 15.00),
                                                                                                (1, '2023-10-05 15:30:00', 'Finished reading "The Great Gatsby".', 0, 15.00);

-- Bob (user_id = 2) - 2 Memories
INSERT INTO memory (user_id_created, date_time_created, memoryText, is_public, averageTemp) VALUES
                                                                                                (2, '2023-10-02 08:45:00', 'Ran 5k this morning, new personal best!', 1, 15.00),
                                                                                                (2, '2023-10-07 19:00:00', 'Tried a new Thai restaurant tonight. Delicious!', 1, 15.00);

-- Charlie (user_id = 3) - 2 Memories
INSERT INTO memory (user_id_created, date_time_created, memoryText, is_public, averageTemp) VALUES
                                                                                                (3, '2023-09-28 12:00:00', 'Landed the big client contract!', 0, 15.00),
                                                                                                (3, '2023-10-04 14:00:00', 'Started learning guitar. Tough but fun.', 0, 15.00);

-- Diana (user_id = 4) - 2 Memories
INSERT INTO memory (user_id_created, date_time_created, memoryText, is_public, averageTemp) VALUES
                                                                                                (4, '2023-10-03 21:00:00', 'Watched a beautiful sunset from the mountain peak.', 1, 15.00),
                                                                                                (4, '2023-10-08 09:15:00', 'Attended a fascinating lecture on astrophysics.', 1, 15.00);

-- Ethan (user_id = 5) - 2 Memories
INSERT INTO memory (user_id_created, date_time_created, memoryText, is_public, averageTemp) VALUES
                                                                                                (5, '2023-10-06 17:00:00', 'Baked a perfect loaf of sourdough bread today.', 0, 15.00),
                                                                                                (5, '2023-10-09 11:30:00', 'Upgraded my computer RAM. Much faster now.', 0, 15.00);


SELECT * FROM memory;