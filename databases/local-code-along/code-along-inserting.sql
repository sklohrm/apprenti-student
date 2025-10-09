USE code_along;

-- Standard Insert
INSERT INTO Payment (paymentid, paymentmethodid, orderid, amount)
VALUES (1001, 1, 101, 49.99);

-- Not Recommended
INSERT INTO Payment
VALUES (1002, 1, 102, 9.99);

-- Omit Payment ID
INSERT INTO Payment (PaymentMethodId, OrderId, Amount)
VALUES (1, 102, 9.99);

SELECT LAST_INSERT_ID(); -- Returning last created ID

-- This fails: Missing FK
INSERT INTO Payment (PaymentMethodId, OrderId, Amount)
VALUES (999, 102, 9.99);

-- Bulk Insert
INSERT INTO Payment (paymentmethodid, orderid, amount)
VALUES
    (1, 101, 10.00),
    (2, 102, 10.00),
    (3, 101, 10.00);

INSERT INTO Payment (PaymentMethodId, OrderId, Amount)
SELECT 1, OrderID, 5.00
FROM CustomerOrder;

-- More Stuff

CREATE TABLE flatPayment2 AS
SELECT
    Payment.PaymentId,
    Payment.OrderId,
    PaymentMethod.MethodName,
    CustomerOrder.CustomerName,
    Payment.Amount
FROM Payment
INNER JOIN CustomerOrder ON Payment.OrderId = CustomerOrder.OrderId
INNER JOIN PaymentMethod ON Payment.PaymentMethodId = PaymentMethod.PaymentMethodId;

SELECT * FROM flat_payment;