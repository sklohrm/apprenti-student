use code_along;

DROP TABLE IF EXISTS ProductCategory, Product;

CREATE TABLE ProductCategory (
                                 CategoryId INT PRIMARY KEY,
                                 CategoryName VARCHAR(50)
);
CREATE TABLE Product (
                         ProductId INT PRIMARY KEY,
                         ProductName VARCHAR(100),
                         CategoryId INT,
                         Price DECIMAL(10, 2),
                         FOREIGN KEY (CategoryId) REFERENCES ProductCategory(CategoryId)
);
INSERT INTO ProductCategory VALUES
                                (1, 'Books'),
                                (2, 'Stationery'),
                                (3, 'Clearance');
INSERT INTO Product VALUES
                        (101, 'Notebook', 2, 5.00),
                        (102, 'Pen Set', 2, 7.50),
                        (103, 'Calendar 2023', 2, 9.99),
                        (104, 'Mystery Novel', 1, 15.00),
                        (105, 'Classic Fiction', 1, 12.50),
                        (106, 'Sticker Pack', 3, 2.99);

-- Part 1: Delete a Single Record
-- 1. Write a SELECT query to find the product with the name 'Calendar 2023'.
SELECT *
FROM Product
WHERE ProductName = 'Calendar 2023';

-- 2. Use a DELETE statement to remove that product from the table.
DELETE FROM Product
WHERE ProductName = 'Calendar 2023';


-- Part 2: Delete Multiple Records
-- 3. Write a SELECT query to preview all products in the 'Stationery' category.
SELECT *
FROM Product p
         JOIN ProductCategory pc ON p.CategoryId = pc.CategoryId
WHERE pc.CategoryName = 'Stationery';

-- 4. Use a DELETE statement to remove all products in that category.
DELETE FROM Product
WHERE CategoryId = 2;

-- Part 3: Handle Foreign Key Dependencies
-- 5. Try to delete the 'Books' category from the ProductCategory table.
SELECT * FROM ProductCategory;
DELETE FROM ProductCategory
WHERE CategoryId = 1;

-- • What happens? Record the error message (if any).
-- The Delete fails because CategoryId is a foreign key on the Product table and there are
-- record on that table that are using that key.
# [23000][1451] Cannot delete or update a parent row:
#     a foreign key constraint fails (`code_along`.`product`,
#     CONSTRAINT `product_ibfk_1` FOREIGN KEY (`CategoryId`) REFERENCES `productcategory` (`CategoryId`))

-- 6. Now safely remove the 'Books' category by deleting its related products first.
DELETE FROM Product
WHERE CategoryId = 1;

DELETE FROM ProductCategory
WHERE CategoryId = 1;

SELECT * FROM Product;
SELECT * FROM ProductCategory;