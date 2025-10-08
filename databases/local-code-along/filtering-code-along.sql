USE SimpleSchool;

-- Filtering by String
SELECT SubjectID, CourseName
  FROM Course
 WHERE CourseName = 'Algebra 1';

-- Filtering by Numeric
SELECT SubjectID, CourseName, CreditHours
  FROM Course
 WHERE CreditHours = 3;

SELECT SubjectID, CourseName, CreditHours
  FROM Course
 WHERE CreditHours > 3;

SELECT SubjectID, CourseName, CreditHours
  FROM Course
 WHERE CreditHours BETWEEN 3 AND 5;

-- Filtering by Date
SELECT SemesterID, StartDate, EndDate
  FROM Semester
 WHERE StartDate BETWEEN '2022-01-01' AND '2022-12-31';

-- Handling Null Values
SELECT RoomID, RoomNumber
  FROM Room
 WHERE Description IS NULL;

SELECT RoomID, RoomNumber, Description
  FROM Room
 WHERE Description IS NOT NULL;

SELECT
    RoomID,
    RoomNumber,
    IFNULL(Description, 'Standard Room') AS Description
  FROM Room;

-- Filtering on Multiple Columns
SELECT
    RoomID,
    RoomNumber,
    IFNULL(Description, 'Standard Room') AS Descriptoin
  FROM Room
 WHERE Description IS NULL;

SELECT SubjectID, CourseName, CreditHours
  FROM Course
 WHERE CourseName LIKE '%y%'
   AND CreditHours BETWEEN 3 AND 5;

SELECT SubjectID, CourseName, CreditHours
  FROM Course
 WHERE CourseName LIKE '___E%'
   AND CreditHours BETWEEN 3 AND 5;

-- AND vs OR vs XOR
SELECT
    RoomID,
    RoomNumber,
    BuildingID,
    IFNULL(Description, 'Standard Room') AS Descriptoin
  FROM Room
 WHERE Description IS NULL
   AND BuildingID = 1;

SELECT
    RoomID,
    RoomNumber,
    BuildingID,
    IFNULL(Description, 'Standard Room') AS Descriptoin
  FROM Room
 WHERE Description IS NULL
    OR BuildingID = 2;

SELECT
    RoomID,
    RoomNumber,
    BuildingID,
    IFNULL(Description, 'Standard Room') AS Descriptoin
  FROM Room
 WHERE Description IS NULL
   XOR BuildingID = 2;

-- In

SELECT *
  FROM Room
 WHERE RoomNumber IN (100, 101, 102);

SELECT
    SemesterID,
    YEAR(StartDate) AS SchoolYear,
    StartDate,
    EndDate
  FROM semester
 WHERE YEAR(StartDate) IN ('2021', '2022');

-- Order by
SELECT
    SemesterID,
    YEAR(StartDate) AS SchoolYear,
    StartDate,
    EndDate
  FROM semester
ORDER BY
    SchoolYear DESC,
    StartDate DESC;