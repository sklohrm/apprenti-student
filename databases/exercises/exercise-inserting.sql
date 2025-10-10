DROP DATABASE IF EXISTS exercise_inserting;
CREATE DATABASE exercise_inserting;
USE exercise_inserting;

CREATE TABLE Customer (
                          CustomerId INT AUTO_INCREMENT PRIMARY KEY,
                          CustomerName VARCHAR(100)
);
CREATE TABLE CustomerOrder (
                               OrderId INT AUTO_INCREMENT PRIMARY KEY,
                               CustomerId INT,
                               OrderDate DATE,
                               FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId)
);
CREATE TABLE PaymentMethod (
                               PaymentMethodId INT PRIMARY KEY,
                               MethodName VARCHAR(50)
);
CREATE TABLE Payment (
                         PaymentId INT AUTO_INCREMENT PRIMARY KEY,
                         OrderId INT,
                         PaymentMethodId INT,
                         Amount DECIMAL(10, 2),
                         FOREIGN KEY (OrderId) REFERENCES CustomerOrder(OrderId),
                         FOREIGN KEY (PaymentMethodId) REFERENCES PaymentMethod(PaymentMethodId)
);

INSERT INTO PaymentMethod VALUES
                              (1, 'Credit Card'),
                              (2, 'Cash'),
                              (3, 'Mobile Payment');

# Instructions
# Part 1: Insert Single Records
# 1. Insert two new customers: Emma Rivera and Noah Gray into the Customer table.
INSERT INTO Customer (CustomerName)
VALUES ('Emma Rivera'),
       ('Noah Gray');

# 2. Create an order for each customer with today's date in the CustomerOrder table.
INSERT INTO CustomerOrder (CustomerId, OrderDate)
VALUES
    ((SELECT CustomerId FROM Customer WHERE CustomerName = 'Emma Rivera'), CURDATE()),
    ((SELECT CustomerId FROM Customer WHERE CustomerName = 'Noah Gray'), CURDATE());

# Part 2: Insert with Auto-Increment Key
# 3. Insert a payment of $49 . 99 for Emma's order using PaymentMethodld 1.
#    Do not specify the PaymentId.
INSERT INTO Payment (OrderId, PaymentMethodId, Amount)
VALUES (1, 1, 49.99);

# Part 3: Handle Foreign Keys
# 4. Try inserting a payment using PaymentMethodId = 999. What happens?
INSERT INTO Payment (OrderId, PaymentMethodId, Amount)
VALUES (1, 999, 49.99);

# • Write down the error message you receive.
# [23000][1452] Cannot add or update a child row: a foreign key constraint fails
#     (`exercise_inserting`.`payment`,
#     CONSTRAINT `payment_ibfk_2`
#     FOREIGN KEY (`PaymentMethodId`)
#     REFERENCES `paymentmethod` (`PaymentMethodId`))
SELECT * FROM PaymentMethod;
-- We are not allowed to add a Payment with a PaymentMethodId that does not already exist on the
-- PaymentMethod table.

# Part 4: Bulk Insert
# • Liam Davis
# • Olivia Brooks
# • Sophia Martinez
# 5. Insert three additional customers in a single INSERT statement:
INSERT INTO Customer (CustomerName)
VALUES ('Liam Davis'),
       ('Olivia Brooks'),
       ('Sophia Martinez');

# 6. Insert a bulk list of two orders (use today's date) for any two of the new customers.
INSERT INTO CustomerOrder (CustomerId, OrderDate)
VALUES
    ((SELECT CustomerId FROM Customer WHERE CustomerName='Liam Davis'), CURDATE()),
    ((SELECT CustomerId FROM Customer WHERE CustomerName='Olivia Brooks'), CURDATE());
SELECT * FROM CustomerOrder;

# Reflection Questions
# • What happens if you try to insert a record that violates a foreign key constraint?
-- The insert will fail.

# • Why is using auto-increment helpful for primary keys?
-- It automatically tracks and inserts the key, so you don't have to worry about it yourself.

# • What are the benefits of bulk inserting records?
-- You can insert many rows with one statement.