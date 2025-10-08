USE SimpleSchool;

-- SELECT
--    field
-- FROM
--    table
-- JOIN
--    table
-- WHERE
--    Clause
-- ORDER
--    Clause


SELECT FirstName, LastName
  FROM Teacher;


SELECT
    T.FirstName,
    T.LastName,
    S.SectionID
  FROM Teacher T
  JOIN Section S ON T.TeacherID = S.SectionID;

SELECT
    T.FirstName,
    T.LastName,
    S.SectionID
  FROM Teacher T
  JOIN Section S ON T.TeacherID = S.SectionID
 WHERE S.SemesterID = 6;

SELECT
    T.FirstName,
    T.LastName,
    S.SectionID
 FROM Teacher T
 LEFT JOIN Section S ON T.TeacherID = S.SectionID
WHERE S.SemesterID = 6;

-- Join Multiple Tables

SELECT
    CONCAT(T.LastName, ', ', T.FirstName) AS 'Teacher Name',
    U.SubjectName AS 'Subject',
    C.CourseName AS 'Course',
    C.CreditHours AS 'Credits'
 FROM Teacher T
 JOIN Section S ON T.TeacherID = S.TeacherID
 JOIN Course  C ON S.CourseID  = C.CourseID
 JOIN Subject U ON C.SubjectID = U.SubjectID
WHERE S.SemesterID = 6
ORDER BY U.SubjectName, T.LastName, T.FirstName, C.CreditHours;

-- "Let's get crazy here"
SELECT
    RoomNumber
  FROM Room R
 RIGHT JOIN Section S ON R.RoomID = S.RoomID
 WHERE R.RoomID IS NULL;

SELECT *
  FROM SectionRoster
 RIGHT JOIN
      Student ON Student.StudentID = SectionRoster.StudentID
 WHERE SectionRoster.StudentID IS NULL;

SELECT *
FROM SectionRoster
RIGHT JOIN Student
    ON Student.StudentID = SectionRoster.StudentID
WHERE SectionRoster.StudentID IS NULL

UNION ALL

SELECT *
FROM SectionRoster
LEFT JOIN Student
    ON Student.StudentID = SectionRoster.StudentID
WHERE SectionRoster.StudentID IS NULL;