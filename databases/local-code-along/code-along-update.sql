USE code_along;

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
                        (105, 'Classic Fiction', 1, 12.50, NULL),
                        (106, 'Sticker Pack', 3, 2.99, NULL);


-- Update a Single Record
UPDATE Product
SET Price = 6.00
WHERE ProductID = 101;

-- Update Multiple Columns
UPDATE Product
SET
    Price = 8.99,
    ProductName = 'Deluxe Pen Set'
WHERE ProductId = 102;

-- Set End Date for All Stationary Items
-- Update 3 Rows
UPDATE Product
SET EndDate = '2024-12-31'
WHERE CategoryId = 2;

SELECT * FROM Product;

-- This should fail: Invalid FK
UPDATE Product
SET CategoryId = 999
WHERE ProductId = 103;

-- This should work: Valid FK
UPDATE Product
SET CategoryId = 3
WHERE ProductId = 103;

UPDATE Product
SET CategoryId = (SELECT CategoryId FROM ProductCategory WHERE CategoryName = 'Clearance'),
    Price = 10.00
WHERE ProductId = 104;