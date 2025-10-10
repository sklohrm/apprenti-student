DROP DATABASE IF EXISTS exercise_updating;
CREATE DATABASE exercise_updating;
USE exercise_updating;

CREATE TABLE ProductCategory (
                                 CategoryId INT PRIMARY KEY,
                                 CategoryName VARCHAR(50)
);
CREATE TABLE Product (
                         ProductId INT PRIMARY KEY,
                         ProductName VARCHAR(100),
                         CategoryId INT,
                         Price DECIMAL(10, 2),
                         EndDate DATE,
                         FOREIGN KEY (CategoryId) REFERENCES ProductCategory(CategoryId)
);
INSERT INTO ProductCategory VALUES
                                (1, 'Books'),
                                (2, 'Stationery'),
                                (3, 'Clearance');
INSERT INTO Product VALUES
                        (101, 'Notebook', 2, 5.00, NULL),
                        (102, 'Pen Set', 2, 7.50, NULL),
                        (103, 'Calendar 2023', 2, 9.99, NULL),
                        (104, 'Mystery Novel', 1, 15.00, NULL),
                        (105, 'Classic Fiction', 1, 12.50, NULL);

# Part 1: Update a Single Record
# 1. Update the price of 'Notebook' to $6.25.
UPDATE Product
SET Price = 6.25
WHERE ProductId = 101;


# Part 2: Update Multiple Columns
# 2. Update 'Pen Set' to:
# • New name: 'Executive Pen Set'
# • New price: $8.99
UPDATE Product
SET ProductName = 'Executive Pen Set',
    Price = 8.99
WHERE ProductId = 102;


# Part 3: Update Multiple Records
# 3. Set the EndDate to '2024-12-31' for all products in the 'Stationery' category.
# Hint: Use a subquery or Categoryld directly based on the data provided.
UPDATE Product
SET
    EndDate = '2024-12-31'
WHERE CategoryId = (SELECT CategoryId FROM ProductCategory WHERE CategoryName = 'Stationery');

SELECT * FROM Product;

# Part 4: Handle Foreign Key Relationships
# 4. Try to update the CategoryId of 'Calendar 2023' to a value that does not exist (e.g., 999).
UPDATE Product
SET CategoryId = 999
WHERE ProductName = 'Calendar 2023';

# • What happens? Record the error message.
-- It fails to update.
-- [23000][1452] Cannot add or update a child row:
-- a foreign key constraint fails (`exercise_updating`.`product`,
-- CONSTRAINT `product_ibfk_1` FOREIGN KEY (`CategoryId`) REFERENCES `productcategory` (`CategoryId`))

# • Then, update it to 'Clearance' (Categoryld 3) instead.
UPDATE Product
SET CategoryId = 3
WHERE ProductName = 'Calendar 2023';