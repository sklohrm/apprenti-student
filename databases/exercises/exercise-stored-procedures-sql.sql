DROP DATABASE IF EXISTS exercise_stored_procedures_and_transactions;
CREATE DATABASE exercise_stored_procedures_and_transactions;

USE exercise_stored_procedures_and_transactions;

-- Create Customer table
CREATE TABLE Customers (
    CustomerId INT AUTO_INCREMENT PRIMARY KEY,
    CustomerName VARCHAR(255) NOT NULL,
    Email VARCHAR(255),
    Phone VARCHAR(20),
    Status VARCHAR(20) NOT NULL
);

-- Insert sample data
INSERT INTO Customers (CustomerName, Email, Phone, Status) VALUES
    ('John Doe', 'john.doe@email.com', '555-0101', 'Active'),
    ('Jane Smith', 'jane.smith@email.com', '555-0102', 'Active'),
    ('Bob Johnson', 'bob.johnson@email.com', '555-0103', 'Inactive'),
    ('Alice Williams', 'alice.williams@email.com', '555-0104', 'Active'),
    ('Charlie Brown', 'charlie.brown@email.com', '555-0105', 'Inactive'),
    ('Diana Davis', 'diana.davis@email.com', '555-0106', 'Active');

# Task 1: Create a Simple Stored Procedure
# 1. Create a stored procedure in either MySQL or SQL Server that selects all the
# columns from a table named Customers where the Status is 'Active'.
DELIMITER //
CREATE PROCEDURE GetActiveCustomers()
BEGIN
    SELECT * FROM Customers
    WHERE Status = 'Active';
END //
DELIMITER ;

# 2. Call your stored procedure to verify that it works as expected.
CALL GetActiveCustomers();

# Task 2: Create a Stored Procedure with a Single Parameter
# 1. Create a stored procedure that accepts an INT parameter for CustomerId and
# returns the customer's details from the Customers table.
DELIMITER //
CREATE PROCEDURE GetCustomerDetails(IN CustomerIdIn INT)
BEGIN
    SELECT * FROM Customers
    WHERE CustomerId = CustomerIdIn;
END //
DELIMITER ;

# 2. Call your stored procedure with a specific CustomerId to retrieve their information.
CALL GetCustomerDetails(1);


# Task 3: Create a Stored Procedure with Multiple Parameters
# 1. Create a stored procedure that takes two parameters: an INT for CustomerId and
# a VARCHAR for CustomerName, then returns customer details where both
# CustomerId and CustomerName match.
DELIMITER //
CREATE PROCEDURE GetCustomerInfo(IN CustomerIdIn INT, IN CustomerNameIn
    VARCHAR(255))
BEGIN
    SELECT * FROM Customers
    WHERE CustomerId = CustomerIdIn AND CustomerName = CustomerNameIn;
END //
DELIMITER ;

# 2. Call your stored procedure with specific values for CustomerId and CustomerName.
CALL GetCustomerInfo(1, 'John Doe');

# Task 4: Modify а Stored Procedure
# 1. Modify the stored procedure from Task 2 to include a check that only returns the
# customer's details if they are active (Status = 'Active").
DROP PROCEDURE IF EXISTS GetCustomerDetails;
DELIMITER //
CREATE PROCEDURE GetCustomerDetails(IN CustomerIdIn INT)
BEGIN
    SELECT * FROM Customers
    WHERE CustomerId = CustomerIdIn AND Status = 'Active';
END //
DELIMITER ;

# 2. Call your modified stored procedure to verify the update.
CALL GetCustomerDetails(1);

# Task 5: Remove a Stored Procedure
# 1. Remove the stored procedure created in Task 3 from the database.
DROP PROCEDURE IF EXISTS GetCustomerInfo;