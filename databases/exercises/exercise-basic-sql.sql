USE SimpleSchool;

-- Select Literal Values
-- 1. Write a SELECT query that uses the string All for one, one for all.
SELECT 'All for one, ', 'and one for all.';

-- 2. Write a SELECT query that uses the CONCAT function to combine All for one, and and one for all.
SELECT CONCAT('All for one, ', 'and one for all.');

-- 3. Write a SELECT query that adds 6 and 6.
SELECT  6 + 6;

-- 4. Write a SELECT query that divides 5 by 2.
SELECT 5 / 2;

-- 5. Write a SELECT query that divides 5.0 by 20.0.
SELECT 5.0 / 2.0;

-- 6. Write a SELECT query with 2 values -6 divided by 4 and the remainder.
SELECT -6 / 4 AS quotient, -6 % 4 AS remainder;

-- 7. Write a SELECT query for 6 squared.
SELECT POW(6, 2) AS squared;

-- Select Against Tables
-- 1. Select all the rows from the Building table.
SELECT * FROM Building;

-- 2. What are the period name, start, and end times?
SELECT periodName AS name, StartTime AS start, EndTime AS end
  FROM Period;

-- 3. Which table is empty?
SELECT table_name
  FROM information_schema.tables
    WHERE TABLE_SCHEMA = DATABASE()
      AND TABLE_ROWS = 0;

-- 4. List all courses and credit hours in the format: CourseName (CreditHours).
SELECT CONCAT(CourseName, ' (', CreditHours, ')') AS CourseInfo
  FROM Course;

-- 5. What are the teachers' full names (first names and last initials) for the first five teachers?
SELECT CONCAT(FirstName, ', ', LEFT(LastName, 1), '.') AS TeacherName
  FROM Teacher LIMIT 5;

-- 6. How many rooms are there?
SELECT COUNT(RoomID) AS RoomCount
  FROM Room;

-- 7. RoomNumber is an integer type. What is the range of room numbers?
SELECT
    MIN(RoomNumber) AS MinRoomNumber,
    MAX(RoomNumber) AS MaxRoomNumber
  FROM Room
 GROUP BY BuildingID;

-- 8. Examine the Description field of the Room table. What are your observations of the description field?
SELECT Description FROM Room;
-- Description is a varchar(50) that can be null.
-- Not a primary key.
-- Only some rooms have a dedicated purpose.

-- 9. How many unique SubjectIDs appear in the Course table?
SELECT COUNT(DISTINCT SubjectID) AS Count FROM Course;

-- 10. How many grade types are there?
SELECT COUNT(GradeTypeID) FROM GradeType;

-- 11. What are the IDs and Names of the grade types?
SELECT
    GradeTypeID AS ID,
    GradeTypeName AS Name
  FROM GradeType;

-- 12. What grade types appear in the GradeItem table?
SELECT GradeTypeName FROM GradeType WHERE GradeTypeID IN (
    SELECT GradeTypeID FROM GradeItem
);


-- 13. What grade types are not utilized in the GradeItem table?
SELECT GradeTypeName FROM GradeType WHERE GradeTypeID NOT IN (
    SELECT GradeTypeID FROM GradeItem
);