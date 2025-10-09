USE SimpleSchool;

-- Subqueries with EXISTS
SELECT COUNT(TeacherID)
FROM Teacher;

SELECT *
FROM Teacher
WHERE EXISTS(
    SELECT TeacherID FROM Section
);

SELECT *
FROM Room
WHERE EXISTS(
    SELECT Description FROM Room
);

-- Use Keys
SELECT * FROM Section WHERE RoomID IN (
    SELECT RoomID
    FROM Room
    WHERE Description IS NOT NULL
    );

SELECT *
FROM Section
WHERE
    RoomID IN (
        SELECT RoomID
        FROM Room
        WHERE Description IS NOT NULL
    )
AND
    TeacherID IN (
        SELECT TeacherID
        FROM Teacher
        WHERE FirstName = 'Geno'
          AND LastName = 'Booy'
    );

-- Scalar Comparison
SELECT TeacherID, COUNT(SectionID)
FROM Section
GROUP BY TeacherID
HAVING COUNT(SectionID) >
       (SELECT COUNT(SectionID) FROM Section
                                WHERE TeacherID IN(
                                SELECT TeacherID
                                FROM Teacher
                                WHERE FirstName = 'Geno'
                                  AND LastName = 'Booy'
                                ));

SELECT *
FROM Teacher;

-- Correlated Subquery
SELECT T.FirstName, T.LastName,
       (SELECT
            COUNT(DISTINCT RoomID)
        FROM Section S
        WHERE T.TeacherID = S.TeacherID
          AND S.SemesterID = (SELECT S.SemesterID
                              FROM Semester S
                              WHERE S.startDate = '2023-04-01')) AS Room_Count
FROM Teacher T;