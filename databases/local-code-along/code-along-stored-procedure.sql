USE code_along;

DROP PROCEDURE IF EXISTS CurrentProductsForCategory;

DELIMITER //
CREATE PROCEDURE CurrentProductsForCategory(IN ProductCategoryIdIn INT)
BEGIN
    SELECT
        ProductId,
        ProductName,
        Price FROM Product
    WHERE CategoryId = ProductCategoryIdIn;
END //
DELIMITER ;

CALL CurrentProductsForCategory(2);

DELIMITER //
CREATE PROCEDURE CurrentProductsForCategoryMaxPrice(
    IN ProductCategoryIdIn INT,
    IN MaxPriceIn DECIMAL)
BEGIN
    SELECT
        ProductId,
        ProductName,
        Price FROM Product
    WHERE CategoryId = ProductCategoryIdIn AND price < MaxPriceIn;
END //
DELIMITER ;

CALL CurrentProductsForCategoryMaxPrice(2, 7);

DELIMITER //
CREATE PROCEDURE CurrentProductsForCategoryPriceInRange(
    IN ProductCategoryIdIn INT,
    IN MinPriceIn DECIMAL,
    IN MaxPriceIn DECIMAL)
BEGIN
    SELECT
        ProductId,
        ProductName,
        Price FROM Product
    WHERE CategoryId = ProductCategoryIdIn AND price > MinPriceIn AND price < MaxPriceIn;
END //
DELIMITER ;

CALL CurrentProductsForCategoryPriceInRange(2, 5, 9);

