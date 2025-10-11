USE SimpleSchool;

# 1. Add a new subject to the database named "Comp. Science."
INSERT INTO Subject (SubjectName)
VALUES ('Comp. Science');

SELECT * FROM Subject;

# 2. Modify the new subject's name to "Computer Science."
UPDATE Subject
SET SubjectName = 'Computer Science'
WHERE SubjectName = 'Comp. Science';

SELECT * FROM Subject;

# 3. Add the following courses to the database, all in the Computer Science subject:
# a. Java 3 credit hours
# b. C# 3 credit hours
# c. JavaScript 3 credit hours
# d. Advanced Java 3 credit hours
INSERT INTO Course (SubjectID, CourseName, CreditHours)
VALUES
    (6, 'Java', 3.0),
    (6, 'C#', 3.0),
    (6, 'JavaScript', 3.0),
    (6, 'Advanced Java', 3.0);

SELECT * FROM Course WHERE SubjectID = 6;

# 4. Rename the course "Java" to "Java 101."
UPDATE Course
SET CourseName = 'Java 101'
WHERE CourseID = 24;

SELECT * FROM Course WHERE CourseID = 24;

# 5. Rename the course "Advanced Java" to "Java 201," and credit hours should be
UPDATE Course
SET
    CourseName = 'Java 201',
    CreditHours = 4.0
WHERE CourseID = 27;

SELECT * FROM Course WHERE CourseID = 27;

# 6. Delete the "Computer Science" subject.
DELETE FROM Subject
WHERE SubjectID = 6;

# a. What error message did you get?
--  Cannot delete or update a parent row: a foreign key constraint fails

# b. Why did you get that error message?
-- Because the Courses that we added earlier are using that SubjectID as a Foreign Key.

# 7. Delete the "Java 101" course.
DELETE FROM Course
WHERE CourseID = 24;

SELECT * FROM Course WHERE SubjectID = 6;

# 8. Delete the remaining "Computer Science" courses with one statement.
DELETE FROM Course
WHERE SubjectID = 6;

# 9. Delete the "Computer Science" subject.
DELETE FROM Subject
WHERE SubjectID = 6;

SELECT * FROM Subject WHERE SubjectID = 6;