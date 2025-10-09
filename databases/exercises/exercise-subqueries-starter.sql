USE SimpleSchool;
-- Part 1: Using NOT EXISTS
--  Write a query to list all Students that are not registered for a class
-- Hint(Check the Section Roster)
SELECT
    S.StudentID,
    S.FirstName,
    S.LastName
FROM Student S
WHERE NOT EXISTS(
    SELECT 1
    FROM SectionRoster SR
    WHERE SR.StudentID = S.StudentID
);

-- Part 2: Subqueries in the WHERE Clause
-- Find the name(s) of classes that have the most students registered
SELECT CourseName
FROM Course
WHERE CourseID IN (
    SELECT CourseID
    FROM Section
    WHERE SectionID IN (
        SELECT SectionID
        FROM (
                 SELECT
                     SectionID,
                     COUNT(StudentID) AS StudentCount
                 FROM SectionRoster
                 GROUP BY SectionID
             ) AS SectionCounts
        WHERE StudentCount = (
            SELECT MAX(StudentCount)
            FROM (
                     SELECT COUNT(StudentID) AS StudentCount
                     FROM SectionRoster
                     GROUP BY SectionID
                 ) AS MaxCounts
        )
    )
);

-- Part 3: Subquery in the SELECT Clause
-- Select all Classes Show:
-- The Teacher That is assigned to Instruct
-- The Room That the class is in
-- No Joins Allowed
SELECT
    (SELECT CourseName
     FROM Course C
     WHERE C.CourseID = S.CourseID) AS 'Course Name',
    (SELECT CONCAT(T.LastName, ', ', T.FirstName)
     FROM Teacher T
     WHERE T.TeacherID = S.TeacherID) AS 'Teacher Name',
    (SELECT RoomNumber
     FROM Room R
     WHERE R.RoomID = S.RoomID) AS 'Room Number'
FROM Section S;

-- Part 4: Subquery in the HAVING Clause
-- Use the Query from Part 2. Use Having to determine which class(s)
-- Has the least amount of Students (Must Be in a Subquery)
SELECT CourseName
FROM Course
WHERE CourseID IN (
    SELECT CourseID
    FROM Section
    WHERE SectionID IN (
        SELECT SectionID
        FROM SectionRoster
        GROUP BY SectionID
        HAVING COUNT(StudentID) = (
            SELECT MIN(StudentCount)
            FROM (
                     SELECT COUNT(StudentID) AS StudentCount
                     FROM SectionRoster
                     GROUP BY SectionID
                 ) AS CountsPerSection
        )
    )
);

-- Part 5: Correlated Subquery
-- Return the top 3 Teachers that have the most students to teach 
-- across all classes and semesters
SELECT
    T.TeacherID,
    T.FirstName,
    T.LastName,
    (SELECT COUNT(sr.StudentID)
     FROM SectionRoster sr
     WHERE sr.SectionID IN (
        SELECT S.SectionID
        FROM Section S
        WHERE S.TeacherID = T.TeacherID
     )) AS 'Total Students'
FROM Teacher T
ORDER BY 'Total Students' DESC
LIMIT 3;
