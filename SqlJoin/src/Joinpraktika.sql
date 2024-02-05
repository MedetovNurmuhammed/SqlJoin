create table groups(
                       id serial primary key ,
                       group_name varchar
);

insert into groups(group_name)
values ('Java-12'),
       ('JS-12'),
       ('English'),
       ('Python-1'),
       ('PM-1');

insert into groups(group_name)
values ('PHP'),
       ('TS');


create table courses(
                        id serial primary key ,
                        course_name varchar,
                        date_of_start date,
                        group_id int references groups(id)
);

insert into courses(course_name, date_of_start, group_id)
values ('Java', '2023-10-3', 1),
       ('Js', '2023-10-3', 2),
       ('Python', '2023-4-12', 4),
       ('JS kids', '2022-1-1', 2),
       ('Scratch', '2022-1-1', 1),
       ('Python kids', '2021-3-1', 4),
       ('Technical English', '2020-1-1', 3);

insert into courses (course_name, date_of_start, group_id)
values ('SoftSkills', '2020-12-12', null);


create table mentors(
                        id serial primary key ,
                        first_name varchar,
                        last_name varchar,
                        gender varchar, -- add check
                        email varchar, -- add unique
                        specialization varchar,
                        experience int,
                        course_id int references courses(id)
);

insert into mentors(first_name, last_name, gender, email, specialization, experience, course_id)
values ('Aijamal', 'Asangazieva', 'Female', 'aijamal@gmail.com', 'Java and Python instructor', 2, 1),
       ('Datka', 'Mamatzhanova', 'Female', 'datka@gmail.com', 'Java mentor', 1, 1),
       ('Aijamal', 'Asangazieva', 'Female', 'aijamal@gmail.com', 'Java and Python instructor', 2, 3),
       ('Ainazik', 'Toktomamatova', 'Female', 'ainazik@gmail.com', 'English teacher', 5, 4),
       ('Ulan', 'Kybanychbekov', 'Male', 'ulan@gmail.com', 'JS mentor', 3, 2),
       ('Aizhan', 'Nurmatova', 'Female', 'aizhan@gmail.com', 'PM', 1, null),
       ('Nurisa', 'Mamiraimova', 'Female', 'nurisa@gmail.com', 'Java mentor', 1, null);


create table students(
                         id serial primary key ,
                         first_name varchar,
                         last_name varchar,
                         date_of_birth date,
                         gender varchar, -- add check
                         email varchar, -- add unique
                         group_id int references groups(id)
);

insert into students(first_name, last_name, date_of_birth, gender, email, group_id)
values ('Aizat', 'Duisheeva', '2003-3-13', 'Female', 'aizat@gmail.com', 1),
       ('Ainazik', 'Amangeldieva', '2002-2-2', 'Female', 'ainazik12@gmail.com', 1),
       ('Elizar', 'Aitbekov', '2001-9-9', 'Male', 'elizar@gmail.com', 2),
       ('Bektur', 'Kanybekov', '2000-1-9', 'Male', 'bektur@gmail.com', 2),
       ('Daniel', 'Kamilzhanov', '2004-9-23', 'Male', 'daniel@gmail.com', 2),
       ('Torogeldi', 'Niyazbekov', '2007-3-9', 'Male', 'torogeldi@gmail.com', 1),
       ('Sanzhar', 'Abdymomunov', '1999-9-9', 'Male', 'sanzhar@gmail.com', 1),
       ('Bermet', 'Aitbekova', '1996-6-9', 'Female', 'bermet@gmail.com', 2),
       ('Aziza', 'Arzykulova', '1991-1-31', 'Female', 'aziza@gmail.com', 3),
       ('Kamcybek', 'Kuzobaev', '1994-6-22', 'Male', 'kamchybek@gmail.com', null),
       ('Den', 'Garden', '1970-6-24', 'Male', 'den@gmail.com', 4),
       ('Jay', 'Bird', '1980-6-9', 'Male', 'jay@gmail.com', 4),
       ('RM', 'Kim', '1994-9-12', 'Male', 'rm@gmail.com', 4),
       ('J-Hope', 'Jung', '1994-2-18', 'Male', 'jhope@gmail.com', 4),
       ('Daniella', 'Park', '2005-2-14', 'Female', 'daniella@gmail.com', 4),
       ('Jennie', 'Kim', '1996-1-9', 'Female', 'jennie@gmail.com', null),
       ('Lisa', 'Monoban', '1996-3-27', 'Female', 'lalisa@gmail.com', 4),
       ('Adinai', 'Sharshekeeva', '1992-7-12', 'Female', 'adinai@gmail.com', 3),
       ('Rose', 'Park', '2006-7-12', 'Female', 'rose@gmail.com', 5),
       ('Aikezhan', 'Akhamatova', '1992-1-12', 'Female', 'aikezhan@gmail.com', 5),
       ('Mirbek', 'Nazhmidinov', '2007-12-31', 'Male', 'mirbek@gmail.com', 5),
       ('Aikeldi', 'LastName', '1998-7-12', 'Female', 'aikeldi@gmail.com', 5);


create table lessons(
                        id serial primary key ,
                        lesson_name varchar,
                        course_id int references courses(id)
);

insert into lessons(lesson_name, course_id)
values ('SQL', 1),
       ('Git', 1),
       ('ArrayList', 1),
       ('LinkedList', 1),
       ('Stream', 1),
       ('HTML', 2),
       ('CSS', 2),
       ('UI-UX', null),
       ('Teg', 2),
       ('Verbs', 4),
       ('Noun', 4),
       ('Adjective', 4),
       ('Adverb', 4),
       ('sout', 3);
-- Получите все записи таблицы groups;
select * from groups;
-- Получите общее количество записей таблицы groups
select count(*) from groups;
--  Выведите группы их курсы
select * from groups inner join courses on groups.id = courses.group_id;
-- Выведите курсы групп у которых курс начался с 2020-1-1 по 2023-3-3
select * from groups inner join courses on groups.id = courses.group_id where date_of_start between '2020-1-1' and '2023-3-3';
-- Выведите имена, дату рождения студентов , которые родились с 1980-1-1 по 2004-12-12,
-- и название группы
select first_name,date_of_birth from students where date_of_birth between '1980-1-1'and '2004-12-12';
-- Выведите суммарный возраст всех студентов курса 'Python'
select sum(EXTRACT(YEAR FROM AGE(NOW(), date_of_birth))) AS total_age
FROM students
WHERE group_id IN (SELECT group_id FROM courses WHERE course_name = 'Python');
-- Вывести полное имя, возраст, почту студентов и название группы, где айди группы равен 3
select * from students inner join groups on groups.id = students.group_id where groups.id = 3;
-- Вывести все курсы одной группы, где название группы 'Java-12'
select * from courses inner join groups on courses.group_id = groups.id where groups.group_name like ('Java-12');
-- Вывести название всех групп и количество студентов в группе
SELECT g.group_name, COUNT(s.id) AS student_count
FROM groups g
         LEFT JOIN students s ON g.id = s.group_id
GROUP BY g.group_name, g.id;
-- Вывести название всех групп и количество студентов в группе, если в группе больше
-- 4 студентов
SELECT g.group_name, COUNT(student.id) AS student_count
FROM groups g
         LEFT JOIN students student ON g.id = student.group_id
GROUP BY g.group_name
HAVING COUNT(student.id) > 4;
-- Отсортируйте имена студентов группы по убыванию, где айди группы равна 4 и выведите
-- айди студента, имя, пол и название группы

SELECT students.id, students.first_name, students.gender, groups.group_name
FROM students
         JOIN groups ON students.group_id = groups.id
WHERE students.group_id = 4
ORDER BY students.first_name ASC;
-- Вывести все курсы
select * from courses;
-- -- Вывести все уроки курса 'Technical English'
select * from lessons inner join courses on lessons.course_id = courses.id where course_name ='Technical English';
-- -- Вывести количество всех студентов курса id = 4
select count(students.id) from students inner join courses on students.group_id = courses.group_id where courses.group_id = 4;
-- -- Вывести имя, почту, специализацию ментора и название курса где курс айди равен 2
select first_name,email,specialization,course_name from mentors inner join courses on mentors.course_id = courses.id where courses.id  =2;
-- -- Посчитить сколько менторов в каждом курсе
select courses.course_name,count(mentors.id) as kolvo
from courses left join mentors on courses.id = mentors.course_id group by
     courses.course_name,mentors.id;
-- -- Сгруппируйте и посчитайте менторов в каждом курсе и выведите
-- только те курсы, где в курсе больше 2 менторов
SELECT courses.*, COUNT(mentors.course_id) AS count_mentors
FROM courses
         INNER JOIN mentors ON courses.id = mentors.course_id
GROUP BY courses.id, courses.course_name
HAVING COUNT(mentors.course_id) > 1;
-- -- Вывести название, дату и полное имя ментора, все курсы которые
-- начинаются с 2020-1-1 по 2023-3-3
select courses.course_name,courses.date_of_start,mentors.first_name,mentors.last_name from
                    courses full join mentors on courses.id = mentors.course_id where
                                                                 courses.date_of_start between '2020-1-1' and '2023-3-3';

-- -- Вывести имя, почту, возраст студентов курса 'Java'
select s.first_name,s.email,s.date_of_birth from students s inner join courses c on s.group_id = c.group_id where course_name = 'Java';
-- -- Вывести тот курс у где нет ментора
select * from courses left join mentors on courses.id = mentors.course_id where mentors.course_id is null;
-- -- Вывести тот курс у где нет уроков
select * from courses left join lessons on courses.id = lessons.course_id where lessons.course_id is null;
-- -- Вывести тот курс у где нет студентов
SELECT courses.*
FROM courses
         LEFT JOIN students ON courses.id = students.group_id
WHERE students.id IS NULL;

-- 1. -- Вывести общее количество студентов
SELECT  COUNT(*) AS total_students
FROM students
WHERE EXTRACT(YEAR FROM AGE('2024-01-01', students.date_of_birth)) > 18;
-- -- Вывести имя, почту и пол студента, айди группы которого равна 2
SELECT S.FIRST_NAME,S.EMAIL,S.GENDER FROM students S WHERE S.id  =2;
-- -- Вывести суммарный возраст всех студентов, которые младше 20
SELECT SUM(EXTRACT (YEAR FROM AGE('2024-01-20',S.DATE_OF_BIRTH))) AS SUMM FROM students S
        WHERE (EXTRACT (YEAR FROM AGE('2024-01-20',S.DATE_OF_BIRTH)))<20;
-- -- Вывести группу студента, айди которого равна 4
SELECT * FROM students INNER JOIN groups ON students.group_id = groups.id WHERE students.id = 4;
-- -- Сгруппируйте студентов по gender и выведите общее количество gender
SELECT  gender, count(*)  AS TOTAL FROM students S GROUP BY gender;
-- -- Найдите студента с айди 8 и обновите его данные
UPDATE students SET first_name = 'Aman' WHERE id = 8;
-- -- Найдите самого старшего студента курса, айди курса которого равна 5
select * FROM students INNER JOIN courses ON students.group_id = courses.group_id WHERE courses.id = 5 ORDER BY students.date_of_birth DESC LIMIT 1;
-- -- Добавьте unique constraint email в столбец таблицы students
ALTER TABLE students
    ADD CONSTRAINT email UNIQUE (email);
-- -- Добавьте check constraint gender в столбец таблицы mentors
ALTER TABLE mentors ADD CONSTRAINT gender check ( gender in ('Male' ,'Female'));
-- -- Добавьте check constraint gender в столбец таблицы students
alter table students add constraint gender check ( gender in ('Male','Female'));
-- -- Переименуйте таблицу mentors в instructors
alter table mentors rename to instructors;
-- Вывести имя, почту и специализацию ментора группы 'Java-9'
select first_name,email,specialization,group_name from instructors inner join groups on instructors.id = groups.id where groups.group_name = 'Java-12';
-- Вывести всех менторов, чей опыт превышает 1 год
select * from instructors where instructors.experience>1;
-- Вывести ментора у которого нет курса
select * from instructors left outer join courses on instructors.course_id = courses.id where instructors.course_id is null;
-- Вывести айди, имя ментора и его студентов
select instructors.id,instructors.first_name ,students.first_name from instructors inner join students on instructors.course_id = students.group_id;
-- Посчитать сколько студентов у каждого ментора, и вывести полное имя ментора и количество его студентов
-- Вывести ментора у которого нет студентов
SELECT
i.id AS mentor_id,
    i.first_name || ' ' || i.last_name AS mentor_full_name,
    COUNT(S.id) AS student_count
FROM
    instructors i
        LEFT JOIN
    students S ON i.id = S.group_id
GROUP BY
    i.id, mentor_full_name
ORDER BY
    mentor_full_name;

-- Вывести ментора у которого студентов больше чем 2
SELECT
    i.id AS mentor_id,
    i.first_name || ' ' || i.last_name AS mentor_full_name,
    COUNT(S.id) AS student_count
FROM
    instructors i
        LEFT JOIN
    students S ON i.id = S.group_id
GROUP BY
    i.id, mentor_full_name
HAVING
        COUNT(S.id) > 2
ORDER BY
    mentor_full_name;
-- Вывести курсы ментора с айди 5
select * from instructors i inner join courses c on c.id = i.course_id where  i.id = 5;
-- Вывести все уроки ментора, айди которого равен 5
select * from instructors i inner join lessons l on i.course_id = l.course_id where i.id = 5;
-- Lesson:
-- Вывести все уроки
select * from lessons;
-- Получить все уроки студента, айди которого равен 2
select * from students inner join lessons l on students.group_id = l.course_id where students.id = 2;
-- Посчитать уроки каждой группы и вывести
-- название группы и количество уроков,
-- где количество уроков больше чем 2
SELECT
    g.group_name,
    COUNT(lessons.id) AS count_lesson
FROM
    groups g
        INNER JOIN
    courses c ON g.id = c.group_id
        INNER JOIN
    lessons ON c.id = lessons.course_id
GROUP BY
    g.group_name
HAVING
        COUNT(lessons.id) > 2
ORDER BY
    g.group_name;
-- Отсортировать уроки студента по названию, где айди студента равна 7
SELECT l.lesson_name
FROM lessons l
         INNER JOIN courses c ON l.course_id = c.id
         INNER JOIN students s ON c.group_id = s.group_id
WHERE s.id = 7
ORDER BY l.lesson_name ASC;
-- Получить все уроки курса, где название курса 'Python kids'
SELECT l.id, l.lesson_name
FROM lessons l
         JOIN courses c ON l.course_id = c.id
WHERE c.course_name = 'Python kids';
-- Получить все уроки ментора, айди которого равен 5

SELECT m.id,l.id, l.lesson_name
FROM lessons l
         JOIN instructors m ON l.course_id = m.course_id
WHERE m.id = 5;