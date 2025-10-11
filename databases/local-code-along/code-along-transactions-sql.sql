USE code_along;

DROP TABLE IF EXISTS Accounts;



START TRANSACTION;
INSERT INTO ProductCategory VALUES (4, 'Toys');
UPDATE Product SET CategoryId = 4 WHERE ProductId = 106;
COMMIT;

SELECT * FROM ProductCategory;