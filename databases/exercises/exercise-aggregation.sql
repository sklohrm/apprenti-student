DROP DATABASE IF EXISTS BookBarn;
CREATE DATABASE BookBarn;
USE BookBarn;

-- Create the Genre table
CREATE TABLE Genre (
    GenreId INT PRIMARY KEY,
    GenreName VARCHAR(100)
);

-- Create the Book table
CREATE TABLE Book (
    BookId INT PRIMARY KEY,
    GenreId INT,
    Title VARCHAR(255),
    Price DECIMAL(10, 2),
    FOREIGN KEY (GenreId) REFERENCES Genre(GenreId)
);

-- Insert data into the Genre table
INSERT INTO Genre (GenreId, GenreName) VALUES
    (1, 'Fiction'),
    (2, 'Business');

-- Insert data into the Book table
INSERT INTO Book (BookId, GenreId, Title, Price) VALUES
    (1, 1, 'Into the Woods', 14.99),
    (2, 2, 'Startup Fundamentals', 22.00),
    (3, 1, 'Ghost Leaves', 11.50);

-- Create the Staff table
CREATE TABLE Staff (
    StaffId INT PRIMARY KEY,
    LastName VARCHAR(100),
    HireDate DATE
);

-- Insert data into the Staff table
INSERT INTO Staff (StaffId, LastName, HireDate) VALUES
    (1, 'Nguyen', '2020-01-01'),
    (2, 'Smith', '2021-03-15');

-- Create the Sale table
CREATE TABLE Sale (
    SaleId INT PRIMARY KEY,
    StaffId INT,
    Total DECIMAL(10, 2),
    FOREIGN KEY (StaffId) REFERENCES Staff(StaffId)
);

-- Insert data into the Sale table
INSERT INTO Sale (SaleId, StaffId, Total) VALUES
    (101, 1, 295.75),
    (102, 2, 840.20);

-- Part 1: Book Pricing Summary
-- 1. Write a query to calculate the minimum, maximum, and average book price.
SELECT
    MIN(Price) AS 'Minimum Price',
    MAX(Price) AS 'Maximum Price',
    AVG(Price) AS 'Average Price'
FROM Book;

-- 2. Group books by GenreName and find the average price per genre.
SELECT
    G.GenreName,
    ROUND(AVG(B.Price), 2) AS 'Genre Average'
FROM Book B
         JOIN Genre G
              ON B.GenreId = G.GenreId
GROUP BY G.GenreName;

-- 3. Filter to show only genres where the average price exceeds $15.
SELECT
    G.GenreName,
    ROUND(AVG(b.Price), 2) AS 'Genre Average'
FROM Book b
         JOIN Genre G
              ON b.GenreId = G.GenreId
GROUP BY G.GenreName
HAVING AVG(b.Price) > 15;

-- Part 2: Staff Sales Performance
-- 1. Count the total number of sales made by each staff member.
SELECT
    S.LastName,
    COUNT(SA.SaleId) AS 'Total Sales'
FROM Staff S
         JOIN Sale SA
              ON S.StaffId = SA.StaffId
GROUP BY S.StaffId, S.LastName;

-- 2. Calculate total sales value per staff using SUM.
SELECT
    S.LastName,
    SUM(SA.Total) AS 'Total Sales'
FROM Staff S
    JOIN Sale SA
        ON S.StaffId = SA.StaffId
GROUP BY S.StaffId, S.LastName;

-- 3. Show only staff whose sales exceed $800
SELECT
    S.LastName,
    SUM(SA.Total) AS 'Total Sales'
FROM Staff S
    JOIN Sale SA
        ON S.StaffId = SA.StaffId
GROUP BY S.StaffId, S.LastName
HAVING SUM(SA.Total) > 800;

-- 4. Sort staff by total sales descending.
SELECT
    S.LastName,
    SUM(SA.Total) AS 'Total Sales'
FROM Staff S
    JOIN Sale SA
        ON S.StaffId = SA.StaffId
GROUP BY S.StaffId, S.LastName
ORDER BY SUM(SA.Total) DESC;

-- Part 3: Staff Hire Summary
-- 1. Group staff by HireDate and return a comma-separated list of last names
--    hired on each date.
SELECT
    HireDate,
    GROUP_CONCAT(LastName ORDER BY LastName SEPARATOR ', ') AS 'Staff Hired'
FROM Staff
GROUP BY HireDate
ORDER BY HireDate;
