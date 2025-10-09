USE SimpleSchool;

-- 1. Write a SELECT query that gets the StudentID, LastName, and FirstName of all Students
--    with a LastName that starts with Cr.
SELECT StudentID, LastName, FirstName
  FROM Student
 WHERE LastName LIKE 'Cr%';

-- 2. Write a SELECT query that gets all Courses with one of the following SubjectIDs:
--    1,2, 4. Use the OR keyword.
SELECT *
  FROM Course
 WHERE SubjectID = 1 OR 2 OR 4;

-- 3. Write a SELECT query that gets all Courses with one of the following SubjectlDs:
--    1, 2, 4. Use the IN keyword.
SELECT *
  FROM Course
 WHERE SubjectID IN (1, 2, 4);

-- 4. Write a SELECT query that gets the Student record with an id of 42.
SELECT  *
  FROM Student
 WHERE StudentID = 42;

-- 5. Write a SELECT query that gets the Student FirstNames that start with "C" using LIKE.
SELECT FirstName
  FROM Student
 WHERE FirstName LIKE 'C%';

-- 6. Write a SELECT query that gets the Student FirstNames names that start with "Ce" using BETWEEN.
SELECT FirstName
  FROM Student
 WHERE FirstName BETWEEN 'Cd' AND 'Cf';

-- 7. Write a SELECT query that gets the first 10 unique Student LastNames.
SELECT DISTINCT LastName
  FROM Student
 LIMIT 10;

-- 8. Write a SELECT query that returns the first 10 Student records.
SELECT *
  FROM Student
 LIMIT 10;

-- 9. Write a SELECT query that returns the top five Students in reverse alphabetical order by LastName.
SELECT *
  FROM Student
 ORDER BY LastName DESC
 LIMIT 5;