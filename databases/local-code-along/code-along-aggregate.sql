DROP DATABASE IF EXISTS code_along;
CREATE DATABASE code_along;
USE code_along;

-- Drop existing tables (for reruns)
DROP TABLE IF EXISTS `Order`, Server, Item, ItemCategory;

-- Item Categories
CREATE TABLE ItemCategory (
                              ItemCategoryId INT PRIMARY KEY,
                              ItemCategoryName VARCHAR(50)
);

INSERT INTO ItemCategory VALUES
    (1, 'Appetizers'),
    (2, 'Beverages'),
    (3, 'Soups'),
    (4, 'Salads'),
    (5, 'Lunch Entrees'),
    (6, 'Breakfast Entrees'),
    (7, 'Desserts');

-- Items
CREATE TABLE Item (
    ItemId INT PRIMARY KEY,
    ItemCategoryId INT,
    ItemName VARCHAR(50),
    UnitPrice DECIMAL(5,2),
    FOREIGN KEY (ItemCategoryId) REFERENCES ItemCategory(ItemCategoryId)
);

INSERT INTO Item VALUES
    (1, 1, 'Spring Rolls', 8.00),
    (2, 1, 'Garlic Bread', 8.67),
    (3, 2, 'Coffee', 2.00),
    (4, 3, 'Tomato Soup', 6.00),
    (5, 4, 'Caesar Salad', 9.67),
    (6, 5, 'Burger', 12.83),
    (7, 6, 'Pancakes', 8.80),
    (8, 7, 'Ice Cream', 5.67),
    (9, 1, 'Dumplings', 8.33),
    (10, 5, 'Grilled Chicken', 12.83);

-- Servers
CREATE TABLE Server (
    ServerId INT PRIMARY KEY,
    LastName VARCHAR(50),
    HireDate DATE
);

INSERT INTO Server VALUES
    (1, 'Boost', '2020-01-01'),
    (2, 'Mewton', '2020-07-26'),
    (3, 'Van Eeden', '2020-08-08'),
    (4, 'Brassington', '2020-07-21'),
    (5, 'Upstell', '2022-08-01');

-- Orders
CREATE TABLE `Order` (
    OrderId INT PRIMARY KEY,
    ServerId INT,
    Total DECIMAL(7,2),
    FOREIGN KEY (ServerId) REFERENCES Server(ServerId)
);

INSERT INTO `Order` VALUES
    (101, 2, 420.44),
    (102, 3, 1166.27),
    (103, 2, 650.50),
    (104, 5, 1256.93),
    (105, 4, 1606.51);


-- Queries
SELECT
    MIN(UnitPrice) as Minimum,
    MAX(UnitPrice) as Maximum,
    FORMAT(AVG(UnitPrice), 2) as Average
FROM item;

SELECT
    ItemCategory.ItemCategoryId,
    ItemCategory.ItemCategoryName,
    FORMAT(AVG(UnitPrice), 2) as Average
FROM item
JOIN ItemCategory on Item.ItemCategoryId = ItemCategory.ItemCategoryId
GROUP BY ItemCategory.ItemCategoryId;

SELECT
    DATE_FORMAT(Server.HireDate, '%Y-%m') AS HireMonth,
    group_concat(Server.LastName) AS ServersHired
FROM Server
GROUP BY HireMonth
ORDER BY HireMonth;

SELECT
    S.lastName,
    SUM(O.total) AS OrderTotals
  FROM `Order` O
  JOIN Server S ON O.ServerId = S.ServerId
 GROUP BY S.lastName
HAVING OrderTotals > 1100;

SELECT
    IC.ItemCategoryName AS 'Item Category',
    FORMAT(AVG(I.UnitPrice), 2) AS 'Average Price'
FROM Item I
INNER JOIN ItemCategory IC ON I.ItemCategoryId = IC.ItemCategoryId
GROUP BY IC.ItemCategoryName
HAVING AVG(I.UnitPrice) > 8
ORDER BY AVG(I.UnitPrice) DESC;