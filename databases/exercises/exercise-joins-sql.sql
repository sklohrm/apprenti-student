USE SimpleSchool;

-- 1. Write a SELECT query that gets all course names, hours, and subject names
--    where the subject name is "History," without table aliases,
--    using the INNER keyword,
--    and ordered by course name.
SELECT
    Course.CourseName,
    Subject.SubjectName,
    Course.CreditHours
FROM Course
INNER JOIN Subject
    ON Course.SubjectID = Subject.SubjectID
WHERE Subject.SubjectName = 'History'
ORDER BY Course.CourseName;

-- 2. Write a SELECT query that gets all course names, hours, and subject names
--    where the subject name is "History," with table aliases,
--    without the INNER keyword,
--    and ordered by course name.
SELECT
    C.CourseName AS 'Course Name',
    S.SubjectName AS 'Subject Name',
    C.CreditHours AS 'Credit Hours'
FROM Course C
JOIN Subject S ON C.SubjectID = S.SubjectID
WHERE S.SubjectName = 'History'
ORDER BY C.CourseName;

-- 3. Write a SELECT query that gets all course names, hours, and subject names
--    where the subject name is "History," with table aliases,
--    using the INNER keyword,
--    and ordered by course name.
SELECT
    C.CourseName AS 'Course Name',
    S.SubjectName AS 'Subject Name',
    C.CreditHours AS 'Credit Hours'
FROM Course C
INNER JOIN Subject S ON C.SubjectID = S.SubjectID
WHERE S.SubjectName = 'History'
ORDER BY C.CourseName;

-- 4. Write a SELECT query that gets all course names, hours, and subject names
--    where the subject name contains the word "Art" anywhere in the name,
--    ordered by subject name then course name.
SELECT
    C.CourseName AS 'Course Name',
    S.SubjectName AS 'Subject Name',
    C.CreditHours AS 'Credit Hours'
FROM Course C
JOIN Subject S ON C.SubjectID = S.SubjectID
WHERE S.SubjectName LIKE '%Art%'
ORDER BY S.SubjectName, C.CourseName;

-- 5. Write a SELECT query that gets
--    all room numbers, descriptions, and building names for rooms missing description information.
SELECT
    R.RoomNumber AS 'Room Number',
    B.BuildingName AS 'Building Name',
    R.Description AS 'Room Description'
FROM Room R
JOIN Building B ON R.BuildingID = B.BuildingID
WHERE R.Description IS NULL;

-- 6. Get all the course names that are more than three credit hours for the teacher named "Geno Booy."
SELECT
    C.CourseName as 'Course Name'
FROM Course C
INNER JOIN Section S ON S.CourseID = C.CourseID
INNER JOIN Teacher T ON T.TeacherID = S.TeacherID
WHERE
    T.FirstName = 'Geno'
  AND T.LastName = 'Booy'
  AND CreditHours > 3.0;
