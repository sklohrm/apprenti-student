drop database if exists SimpleSchool;

CREATE DATABASE SimpleSchool;

USE SimpleSchool;

CREATE TABLE GradeType (
                           GradeTypeID int primary key auto_increment,
                           GradeTypeName varchar(25) not null
);

CREATE TABLE GradeItem (
                           GradeItemID int primary key auto_increment,
                           GradeTypeID int not null,
                           PointsPossible decimal(5,2) not null default 0,
                           `Description` varchar(255) not null,
                           constraint fk_GradeItem_GradeType_id
                               foreign key (GradeTypeID)
                                   references GradeType(GradeTypeID)
);

CREATE TABLE `Subject` (
                           SubjectID int primary key auto_increment,
                           SubjectName varchar(50) not null
);

CREATE TABLE Course (
                        CourseID int primary key auto_increment,
                        SubjectID int not null,
                        CourseName varchar(50) not null,
                        CreditHours decimal(3,2) not null default 0.0,
                        constraint fk_Course_Subject_id
                            foreign key (SubjectID)
                                references Subject(SubjectID)
);

CREATE TABLE `Period` (
                          PeriodID int primary key auto_increment,
                          PeriodName varchar(50) not null,
                          StartTime time not null,
                          EndTime time not null
);

CREATE TABLE Semester (
                          SemesterID int primary key auto_increment,
                          StartDate date not null,
                          EndDate date not null,
                          `Description` varchar(50) null
);

CREATE TABLE Building (
                          BuildingID int primary key auto_increment,
                          BuildingName varchar(50) not null
);

CREATE TABLE Room (
                      RoomID int primary key auto_increment,
                      BuildingID int not null,
                      RoomNumber int not null default(0),
                      `Description` varchar(50) null,
                      constraint fk_Room_Building_id
                          foreign key (BuildingID)
                              references Building(BuildingID)
);

CREATE TABLE Teacher (
                         TeacherID int primary key auto_increment,
                         FirstName varchar(50) not null,
                         LastName varchar(50) not null
);

CREATE TABLE Student (
                         StudentID int primary key auto_increment,
                         FirstName varchar(50) not null,
                         LastName varchar(50) not null,
                         ClassYear char(4) not null
);

CREATE TABLE Section (
                         SectionID int primary key auto_increment,
                         CourseID int not null,
                         TeacherID int not null,
                         SemesterID int not null,
                         PeriodID int not null,
                         RoomID int not null,
                         constraint fk_Section_Course_id
                             foreign key (CourseID)
                                 references Course(CourseID),
                         constraint fk_Section_Teacher_id
                             foreign key (TeacherID)
                                 references Teacher(TeacherID),
                         constraint fk_Section_Semester_id
                             foreign key (SemesterID)
                                 references Semester(SemesterID),
                         constraint fk_Section_Period_id
                             foreign key (PeriodID)
                                 references `Period`(PeriodID),
                         constraint fk_Section_Room_id
                             foreign key (RoomID)
                                 references Room(RoomID)
);

CREATE TABLE SectionRoster (
                               SectionRosterID int primary key auto_increment,
                               SectionID int not null,
                               StudentID int not null,
                               CurrentGrade decimal(5,2) null,
                               constraint fk_SectionRoster_Section_id
                                   foreign key (SectionID)
                                       references Section(SectionID),
                               constraint fk_SectionRoster_Student_id
                                   foreign key (StudentID)
                                       references Student(StudentID)
);

CREATE TABLE Grade (
                       GradeID int primary key auto_increment,
                       SectionRosterID int not null,
                       GradeItemID int not null,
                       Score decimal(5,2) null,
                       constraint fk_Grade_SectionRoster_id
                           foreign key (SectionRosterID)
                               references SectionRoster(SectionRosterID),
                       constraint fk_Grade_GradeItem_id
                           foreign key (GradeItemID)
                               references GradeItem(GradeItemID)
);

insert into Student (FirstName, LastName, ClassYear) values ('Carlita', 'Charon', 2025);
insert into Student (FirstName, LastName, ClassYear) values ('Deborah', 'Lowing', 2027);
insert into Student (FirstName, LastName, ClassYear) values ('Rennie', 'Fitzjohn', 2026);
insert into Student (FirstName, LastName, ClassYear) values ('Pam', 'Ellicott', 2024);
insert into Student (FirstName, LastName, ClassYear) values ('Gisella', 'Daveren', 2028);
insert into Student (FirstName, LastName, ClassYear) values ('Hazlett', 'Wickson', 2027);
insert into Student (FirstName, LastName, ClassYear) values ('Jaquelin', 'Van Halen', 2025);
insert into Student (FirstName, LastName, ClassYear) values ('Loralyn', 'Casaccia', 2027);
insert into Student (FirstName, LastName, ClassYear) values ('Hailey', 'Aiton', 2027);
insert into Student (FirstName, LastName, ClassYear) values ('Melonie', 'McAdam', 2024);
insert into Student (FirstName, LastName, ClassYear) values ('Jewelle', 'Jelley', 2028);
insert into Student (FirstName, LastName, ClassYear) values ('Lynnet', 'Kemmish', 2023);
insert into Student (FirstName, LastName, ClassYear) values ('Dulci', 'Lamblot', 2023);
insert into Student (FirstName, LastName, ClassYear) values ('Marilin', 'Keeney', 2025);
insert into Student (FirstName, LastName, ClassYear) values ('Zena', 'Tenpenny', 2028);
insert into Student (FirstName, LastName, ClassYear) values ('Chiquita', 'Hustler', 2028);
insert into Student (FirstName, LastName, ClassYear) values ('Marleen', 'Blizard', 2024);
insert into Student (FirstName, LastName, ClassYear) values ('Fletcher', 'Tomczynski', 2023);
insert into Student (FirstName, LastName, ClassYear) values ('Rozina', 'Fardon', 2023);
insert into Student (FirstName, LastName, ClassYear) values ('Dyanne', 'Rourke', 2024);
insert into Student (FirstName, LastName, ClassYear) values ('Dorrie', 'Rigolle', 2023);
insert into Student (FirstName, LastName, ClassYear) values ('Jocelyne', 'Walak', 2023);
insert into Student (FirstName, LastName, ClassYear) values ('Bartlet', 'Heare', 2027);
insert into Student (FirstName, LastName, ClassYear) values ('Osgood', 'Otley', 2026);
insert into Student (FirstName, LastName, ClassYear) values ('Sergeant', 'Hartmann', 2023);
insert into Student (FirstName, LastName, ClassYear) values ('Trudy', 'Bonett', 2025);
insert into Student (FirstName, LastName, ClassYear) values ('Lauri', 'Coggeshall', 2028);
insert into Student (FirstName, LastName, ClassYear) values ('Cecily', 'Brandsma', 2024);
insert into Student (FirstName, LastName, ClassYear) values ('Esra', 'Langrish', 2024);
insert into Student (FirstName, LastName, ClassYear) values ('Clemens', 'Kalb', 2025);
insert into Student (FirstName, LastName, ClassYear) values ('Denys', 'Hysom', 2024);
insert into Student (FirstName, LastName, ClassYear) values ('Fleurette', 'Galletley', 2024);
insert into Student (FirstName, LastName, ClassYear) values ('Annabel', 'Snow', 2028);
insert into Student (FirstName, LastName, ClassYear) values ('Elwin', 'Truss', 2023);
insert into Student (FirstName, LastName, ClassYear) values ('Sheila', 'Orange', 2026);
insert into Student (FirstName, LastName, ClassYear) values ('Marci', 'Crutchfield', 2026);
insert into Student (FirstName, LastName, ClassYear) values ('Corrie', 'Raistrick', 2027);
insert into Student (FirstName, LastName, ClassYear) values ('Randell', 'Shilstone', 2026);
insert into Student (FirstName, LastName, ClassYear) values ('Pammie', 'De Brett', 2027);
insert into Student (FirstName, LastName, ClassYear) values ('Devy', 'Rozec', 2028);
insert into Student (FirstName, LastName, ClassYear) values ('Desiri', 'Muddle', 2027);
insert into Student (FirstName, LastName, ClassYear) values ('Eal', 'Morphew', 2026);
insert into Student (FirstName, LastName, ClassYear) values ('Molli', 'Dudliston', 2026);
insert into Student (FirstName, LastName, ClassYear) values ('Noble', 'Sandilands', 2024);
insert into Student (FirstName, LastName, ClassYear) values ('Gaelan', 'Ferrillo', 2028);
insert into Student (FirstName, LastName, ClassYear) values ('Emogene', 'Josefson', 2028);
insert into Student (FirstName, LastName, ClassYear) values ('Kerrin', 'Colrein', 2025);
insert into Student (FirstName, LastName, ClassYear) values ('Maure', 'Bartrap', 2023);
insert into Student (FirstName, LastName, ClassYear) values ('Israel', 'Hacker', 2028);
insert into Student (FirstName, LastName, ClassYear) values ('Baudoin', 'Crooks', 2023);
insert into Teacher (FirstName, LastName) values ('Michail', 'Eatherton');
insert into Teacher (FirstName, LastName) values ('Sybille', 'Standish-Brooks');
insert into Teacher (FirstName, LastName) values ('Salomi', 'Arnaldo');
insert into Teacher (FirstName, LastName) values ('Amil', 'Banting');
insert into Teacher (FirstName, LastName) values ('Dimitri', 'Doblin');
insert into Teacher (FirstName, LastName) values ('Auroora', 'Huntriss');
insert into Teacher (FirstName, LastName) values ('Geno', 'Booy');
insert into Teacher (FirstName, LastName) values ('Edsel', 'Lilleyman');
insert into Teacher (FirstName, LastName) values ('Ahmad', 'Enticknap');
insert into Teacher (FirstName, LastName) values ('Bradly', 'Toun');

INSERT INTO GradeType (GradeTypeName)
VALUES ('Homework'), ('Quiz'), ('Project'), ('Exam');

INSERT INTO GradeItem (GradeTypeID, PointsPossible, Description)
VALUES (4, 100, 'Final Exam'),
       (3, 50, 'Capstone Project');

-- 5 subjects
INSERT INTO `Subject` (SubjectName)
VALUES ('Language Arts'), ('Math'), ('Science'), ('Arts'), ('History');

-- 8 periods
INSERT INTO `Period` (PeriodName, StartTime, EndTime)
VALUES ('1st Period', '8:00:00', '8:45:00'),
       ('2nd Period', '9:00:00', '9:45:00'),
       ('3rd Period', '10:00:00', '10:45:00'),
       ('4th Period', '11:00:00', '11:45:00'),
       ('5th Period', '12:00:00', '12:45:00'),
       ('6th Period', '13:00:00', '13:45:00'),
       ('7th Period', '14:00:00', '14:45:00'),
       ('8th Period', '15:00:00', '15:45:00');

-- 6 semesters
INSERT INTO Semester (StartDate, EndDate, `Description`)
VALUES ('2021-09-01', '2021-12-31', null),
       ('2022-01-01', '2022-03-31', null),
       ('2022-04-01', '2022-06-30', null),
       ('2022-09-01', '2022-12-31', null),
       ('2023-01-01', '2023-03-31', null),
       ('2023-04-01', '2023-06-30', null);

-- 2 buildings
INSERT INTO Building (BuildingName)
VALUES ('Main Campus'), ('Vocational Tech Campus');

-- 13 rooms
INSERT INTO Room (BuildingID, RoomNumber, `Description`)
VALUES (1, 100, 'Gymnasium'),
       (1, 101, null),
       (1, 102, null),
       (1, 103, null),
       (1, 104, null),
       (1, 105, null),
       (1, 200, null),
       (1, 201, null),
       (1, 202, null),
       (1, 203, null),
       (1, 204, null),
       (2, 100, 'Chemistry Lab'),
       (2, 101, null);

-- 23 courses
INSERT INTO Course (SubjectID, CourseName, CreditHours)
VALUES (1, 'English 1', 3.0),
       (1, 'English 2', 3.0),
       (1, 'English 3', 3.0),
       (1, 'AP English', 3.0),
       (2, 'Algebra 1', 4.0),
       (2, 'Geometry', 4.0),
       (2, 'Algebra 2', 4.0),
       (2, 'Statistics', 3.0),
       (2, 'Calculus', 4.0),
       (3, 'Biology', 4.0),
       (3, 'Chemistry', 4.0),
       (3, 'Anatomy', 4.0),
       (3, 'Geology', 4.0),
       (4, 'Art 1', 3.0),
       (4, 'Art 2', 3.0),
       (4, 'Choir', 3.0),
       (4, 'Band', 3.0),
       (4, 'Theater', 3.0),
       (5, 'European History', 3.0),
       (5, 'American History', 3.0),
       (5, 'African History', 3.0),
       (5, 'Middle Eastern History', 3.0),
       (5, 'Asian History', 3.0);

INSERT INTO Section (CourseID, TeacherID, SemesterID, PeriodID, RoomID)
VALUES (6, 9, 3, 5, 9),
       (15, 10, 1, 1, 6),
       (11, 2, 1, 1, 13),
       (6, 1, 4, 1, 5),
       (17, 1, 6, 6, 3),
       (18, 10, 6, 7, 2),
       (21, 6, 2, 5, 7),
       (3, 4, 2, 8, 5),
       (2, 8, 2, 7, 11),
       (23, 6, 1, 5, 3),
       (20, 6, 5, 2, 1),
       (12, 7, 4, 5, 2),
       (17, 10, 5, 3, 13),
       (3, 8, 6, 2, 4),
       (13, 3, 1, 3, 8),
       (6, 9, 6, 4, 9),
       (20, 5, 5, 1, 7),
       (9, 8, 1, 7, 11),
       (21, 5, 2, 3, 10),
       (10, 3, 3, 1, 11),
       (3, 7, 6, 7, 7),
       (14, 6, 5, 3, 11),
       (20, 6, 6, 5, 7),
       (9, 8, 4, 4, 11),
       (16, 7, 5, 8, 2),
       (4, 6, 4, 6, 7),
       (2, 6, 2, 2, 5),
       (11, 5, 3, 2, 4),
       (8, 5, 3, 5, 4),
       (18, 6, 3, 2, 9),
       (14, 2, 2, 5, 6),
       (17, 1, 2, 2, 9),
       (18, 7, 5, 5, 12),
       (21, 7, 4, 8, 8),
       (14, 8, 1, 4, 6),
       (17, 2, 5, 8, 1),
       (11, 10, 6, 3, 8),
       (13, 1, 2, 6, 12),
       (22, 10, 5, 8, 10),
       (21, 1, 2, 5, 9),
       (1, 6, 3, 3, 8),
       (11, 7, 4, 3, 4),
       (12, 3, 4, 1, 5),
       (16, 6, 5, 7, 8),
       (6, 4, 1, 7, 4),
       (19, 5, 4, 2, 6),
       (16, 9, 5, 3, 12),
       (6, 2, 6, 5, 10),
       (2, 7, 2, 4, 4),
       (21, 3, 2, 8, 4);

ALTER TABLE SectionRoster ADD CONSTRAINT ucSectionStudent UNIQUE (SectionID, StudentID);

insert into SectionRoster (SectionID, StudentID) values (6, 32),
                                                        (22, 17),
                                                        (46, 4),
                                                        (36, 47),
                                                        (14, 28),
                                                        (48, 18),
                                                        (8, 45),
                                                        (40, 50),
                                                        (5, 24),
                                                        (24, 21),
                                                        (45, 29),
                                                        (1, 40),
                                                        (33, 39),
                                                        (46, 27),
                                                        (19, 49),
                                                        (27, 27),
                                                        (41, 19),
                                                        (13, 10),
                                                        (30, 2),
                                                        (8, 25),
                                                        (23, 41),
                                                        (1, 39),
                                                        (13, 2),
                                                        (2, 13),
                                                        (1, 35),
                                                        (3, 8),
                                                        (40, 36),
                                                        (20, 34),
                                                        (15, 40),
                                                        (40, 21),
                                                        (50, 1),
                                                        (11, 38),
                                                        (33, 25),
                                                        (34, 30),
                                                        (39, 10),
                                                        (13, 7),
                                                        (20, 26),
                                                        (7, 50),
                                                        (2, 16),
                                                        (31, 28),
                                                        (50, 36),
                                                        (38, 23),
                                                        (38, 8),
                                                        (4, 16),
                                                        (10, 9),
                                                        (11, 8),
                                                        (49, 13),
                                                        (46, 2),
                                                        (8, 23),
                                                        (37, 1),
                                                        (31, 3),
                                                        (40, 17),
                                                        (26, 7),
                                                        (20, 21),
                                                        (10, 50),
                                                        (41, 11),
                                                        (4, 19),
                                                        (11, 6),
                                                        (30, 15),
                                                        (10, 3),
                                                        (9, 49),
                                                        (16, 43),
                                                        (15, 22),
                                                        (32, 41),
                                                        (48, 46),
                                                        (29, 18),
                                                        (25, 48),
                                                        (37, 3),
                                                        (21, 44),
                                                        (36, 2),
                                                        (10, 39),
                                                        (1, 2),
                                                        (30, 8),
                                                        (29, 30),
                                                        (21, 11),
                                                        (9, 43),
                                                        (49, 37),
                                                        (7, 38),
                                                        (31, 47),
                                                        (29, 27),
                                                        (27, 35),
                                                        (26, 28),
                                                        (34, 3),
                                                        (38, 4),
                                                        (25, 44),
                                                        (4, 5),
                                                        (40, 6),
                                                        (14, 4),
                                                        (37, 31),
                                                        (20, 13),
                                                        (26, 36),
                                                        (32, 13),
                                                        (16, 20),
                                                        (20, 20),
                                                        (12, 14),
                                                        (27, 39),
                                                        (48, 2),
                                                        (12, 10),
                                                        (42, 23),
                                                        (28, 35),
                                                        (19, 22),
                                                        (39, 38),
                                                        (37, 28),
                                                        (16, 2),
                                                        (9, 39),
                                                        (37, 7),
                                                        (21, 34),
                                                        (13, 9),
                                                        (5, 43),
                                                        (18, 5),
                                                        (34, 15),
                                                        (39, 21),
                                                        (50, 23),
                                                        (20, 11),
                                                        (14, 42),
                                                        (22, 41),
                                                        (37, 47),
                                                        (4, 1),
                                                        (22, 37),
                                                        (14, 44),
                                                        (8, 44),
                                                        (45, 23),
                                                        (21, 29),
                                                        (47, 34),
                                                        (8, 36),
                                                        (11, 48),
                                                        (12, 30),
                                                        (45, 17),
                                                        (32, 9),
                                                        (38, 27),
                                                        (5, 46),
                                                        (45, 7),
                                                        (29, 34),
                                                        (42, 31),
                                                        (43, 20),
                                                        (32, 46),
                                                        (26, 25),
                                                        (10, 45),
                                                        (30, 25),
                                                        (34, 18),
                                                        (18, 25),
                                                        (44, 45),
                                                        (19, 10),
                                                        (1, 6),
                                                        (8, 42),
                                                        (24, 14),
                                                        (30, 47),
                                                        (23, 21),
                                                        (39, 42),
                                                        (44, 28),
                                                        (10, 10),
                                                        (32, 16),
                                                        (29, 24),
                                                        (34, 39),
                                                        (12, 50),
                                                        (35, 23),
                                                        (32, 39),
                                                        (4, 45),
                                                        (30, 3),
                                                        (46, 35),
                                                        (39, 31),
                                                        (18, 6),
                                                        (23, 45),
                                                        (9, 11),
                                                        (26, 46),
                                                        (32, 21),
                                                        (14, 38),
                                                        (30, 30),
                                                        (6, 42),
                                                        (17, 24),
                                                        (43, 16),
                                                        (34, 8),
                                                        (12, 20),
                                                        (47, 7),
                                                        (41, 48),
                                                        (22, 12),
                                                        (2, 19),
                                                        (37, 30),
                                                        (21, 46),
                                                        (35, 9),
                                                        (41, 12),
                                                        (1, 50),
                                                        (32, 38),
                                                        (20, 15),
                                                        (50, 2),
                                                        (8, 12),
                                                        (40, 46),
                                                        (40, 20),
                                                        (31, 34),
                                                        (12, 48),
                                                        (1, 15),
                                                        (35, 21),
                                                        (35, 16);
