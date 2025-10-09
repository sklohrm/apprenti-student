DROP DATABASE IF EXISTS code_along;
CREATE DATABASE code_along;
USE code_along;

-- Create the customers table
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    First_Name VARCHAR(50),
    Last_Name VARCHAR(50)
);

-- Insert sample data
INSERT INTO customers VALUES
    (101, 'john', 'DOE'),
    (102, 'SARAH', 'smith');

-- Create the orders table
CREATE TABLE orders (
    order_id INT PRIMARY KEY ,
    customer_id INT,
    order_date DATETIME,
    order_total VARCHAR(20),
    CONSTRAINT fk_customer_orders
        FOREIGN KEY (customer_id) REFERENCES  customers (customer_id)
);

-- Insert sample orders
INSERT INTO orders VALUES
    (1, 101, '2025-07-01 14:33:00', '1234.5'),
    (2, 102, '2025-07-03 10:15:22', '8899.99');

SELECT *
FROM customers
WHERE First_Name = 'JOHN';

SELECT
    CONCAT(
        UPPER(LEFT(First_Name, 1)), LOWER(SUBSTR(First_Name, 2)), ' ',
        UPPER(LEFT(Last_Name, 1)), LOWER(SUBSTR(Last_Name, 2))
    ) AS formatted_name
FROM customers;

SELECT
    order_total AS 'Raw Total',
    CAST(order_total AS DECIMAL (10,2)) AS 'Cast Total',
    CONCAT('$', FORMAT(order_total, 2)) AS 'Formatted Total'
FROM orders;

SELECT
    order_date,
    DATE_FORMAT(order_date, '%m-%d-%Y'),
    DATE_FORMAT(order_date, '%M %D, %Y')
FROM orders;

SELECT
    CONCAT(
            UPPER(LEFT(First_Name, 1)), LOWER(SUBSTR(First_Name, 2)), ' ',
            UPPER(LEFT(Last_Name, 1)), LOWER(SUBSTR(Last_Name, 2))
    ) AS 'Customer Name',
    DATE_FORMAT(order_date, '%m-%d-%Y') AS 'Order Date',
    CONCAT('$', FORMAT(order_total, 2)) AS 'Order Total'
FROM customers C
JOIN orders O ON O.customer_id = C.customer_id