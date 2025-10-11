DROP DATABASE IF EXISTS case_casting_formatting;
CREATE DATABASE case_casting_formatting;

USE case_casting_formatting;

DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    First_Name VARCHAR(50),
    Last_Name VARCHAR(50)
);

INSERT INTO customers (customer_id, First_Name, Last_Name) VALUES
    (101, 'john', 'DOE'),
    (102, 'SARAH', 'smith');

DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATETIME,
    order_total VARCHAR(20), -- intentionally using string for exercise
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO orders (order_id, customer_id, order_date, order_total) VALUES
    (1, 101, '2025-07-01 14:33:00', '1234.5'),
    (2, 102, '2025-07-03 10:15:22', '8899.99');

-- Case Sensitivity & Case Formatting
-- 1. Write a query that standardizes the full customer name in Title Case (e.g.,"John Doe").
SELECT
    customer_id,
    CONCAT(
            UPPER(LEFT(First_Name, 1)), LOWER(SUBSTRING(First_Name, 2)),
            ' ',
            UPPER(LEFT(Last_Name, 1)), LOWER(SUBSTRING(Last_Name, 2))
    ) AS Full_Name_TitleCase
FROM customers;


-- 2. Determine whether your database is case-sensitive or not:
--    Try filtering using: SELECT * FROM customers WHERE First_Name = 'JOHN';
SELECT *
FROM customers
WHERE First_Name = 'JOHN'; -- Not case-sensitive

-- Casting
-- 1. Identify which columns need casting in the orders table.
SELECT *
FROM orders;
-- order_total may need casting from string

-- 2. Write a query that casts order_total from VARCHAR to DECIMAL (10, 2) and
--    returns the result as formatted_total.
SELECT
    order_id,
    CAST(order_total AS DECIMAL(10, 2)) AS formatted_total
FROM orders;

-- Formatting
-- 1. Format order_date to 'Month DD, YYYY' (e.g., "July 01, 2025").
SELECT
    DATE_FORMAT(order_date, '%M %d, %Y') AS 'Order Date'
FROM orders;

-- 2. Format order_total to include two decimal places and a thousands separator.
SELECT
    FORMAT(order_total, 2) AS formatted_total
FROM orders;

-- Combined Query Business Report
-- Using JOIN, write a final report query that returns:
-- • Customer full name (in Title Case)
-- • Formatted order date
-- • Formatted order total with two decimal places and commas
SELECT
    CONCAT(
            UPPER(LEFT(C.First_Name, 1)), LOWER(SUBSTRING(C.First_Name, 2)),
            ' ',
            UPPER(LEFT(C.Last_Name, 1)), LOWER(SUBSTRING(C.Last_Name, 2))
    ) AS Customer_Full_Name,
    DATE_FORMAT(O.order_date, '%M %d, %Y') AS Formatted_Order_Date,
    CONCAT('$', FORMAT(O.order_total, 2)) AS Formatted_Order_Total
FROM orders O
         JOIN customers C
              ON O.customer_id = C.customer_id;


-- Reflection Questions
-- • What potential issues could arise from leaving order _total as a string?
--      Trying to do math on the String could cause errors without casting.
--      It changes the sorting order.

-- • How does your database's case sensitivity impact query design?
--      A case-sensitive database could cause some queries to fail.
--      Formatting may be needed to get output that looks readable.

-- • What are the risks of relying solely on implicit casting?
--      Implicit casting can cause errors or unexpected values like NULL.

-- • Why is formatting critical in customer-facing reports?
--      Formatting turns the output into a more readable format. Like how a layperson wouldn't
--      necessarily understand what NULL means.