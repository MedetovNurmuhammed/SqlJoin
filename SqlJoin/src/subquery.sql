create table Publisher(id serial primary key ,name varchar);
insert into Publisher(name)
values ('RELX Group'),
       ('Thomson Reuters'),
       ('Holtzbrinck Publishing Group'),
       ('Shanghai Jiao Tong University Press'),
       ('Wolters Kluwer'),
       ('Hachette Livre'),
       ('Aufbau-Verlag'),
       ('Macmillan'),
       ('Harper Collins'),
       ('China Publishing Group'),
       ('Springer Nature'),
       ('Grupo Planeta'),
       ('Books.Ru Ltd.St Petersburg'),
       ('The Moscow Times'),
       ('Zhonghua Book Company');
create type genre as enum ('DETECTIVE','DRAMA','HISTORY',
    'ROMANCE','BIOGRAPHY','FANTASY');
create table Book(id serial primary key ,
name varchar,country varchar,
published_year date, price numeric,GENRE genre
);
create table language(id serial primary key ,
language varchar not null );
CREATE TYPE GENDER AS ENUM ('MALE','FEMALE');
create table author(id serial primary key ,first_name varchar,
last_name varchar,email varchar unique ,
date_of_birth date,county varchar,gender GENDER);
ALTER TABLE Book ADD COLUMN LANGUAGE_ID INTEGER REFERENCES language(ID),
 ADD  COLUMN PUBLISHER_ID INTEGER REFERENCES Publisher(id),
 ADD COLUMN AUTHOR_ID INTEGER REFERENCES author(ID);
insert into author(first_name, last_name, email, date_of_birth, county, gender)
values ('Sybilla', 'Toderbrugge', 'stoderbrugge0@jugem.jp', '9/25/1968', 'France', 'FEMALE'),
       ('Patti', 'Walster', 'pwalster1@addtoany.com', '10/31/1965', 'China', 'FEMALE'),
       ('Sonnie', 'Emmens', 'semmens2@upenn.edu', '5/16/1980', 'Germany', 'MALE'),
       ('Brand', 'Burel', 'bburel3@ovh.net', '4/24/1964', 'United States', 'MALE'),
       ('Silvan', 'Smartman', 'ssmartman4@spiegel.de', '7/3/1967', 'France', 'MALE'),
       ('Alexey', 'Arnov', 'larnoldi5@writer.com', '12/29/1964', 'Russia', 'MALE'),
       ('Bunni', 'Aggio', 'baggio6@yahoo.co.jp', '12/14/1983', 'China', 'FEMALE'),
       ('Viole', 'Sarath', 'vsarath7@elegantthemes.com', '1/29/1960', 'United States', 'FEMALE'),
       ('Boigie', 'Etridge', 'betridge8@ed.gov', '11/17/1978', 'France', 'MALE'),
       ('Hilliard', 'Burnsyde', 'hburnsyde9@omniture.com', '9/8/1962', 'Germany', 'MALE'),
       ('Margarita', 'Bartova', 'mbartova@example.com', '12/3/1984', 'Russia', 'FEMALE'),
       ('Innis', 'Hugh', 'ihughb@marriott.com', '8/28/1983', 'Germany', 'MALE'),
       ('Lera', 'Trimnella', 'ltrimnellc@msn.com', '3/28/1980', 'Russia', 'FEMALE'),
       ('Jakob', 'Bransby', 'jbransbyd@nasa.gov', '8/5/1966', 'Spain', 'MALE'),
       ('Loretta', 'Gronaver', 'lgronavere@technorati.com', '10/17/1962', 'United States', 'FEMALE');

insert into language(language)
values ('English'),
       ('French'),
       ('German'),
       ('Chinese'),
       ('Russian'),
       ('Spanish');
ALTER TYPE genre ADD VALUE  'ROMANS';
insert into book(name, country, published_year, price, genre, language_id, publisher_id, author_id)
values('Taina', 'Russia', '11/12/2021', '568','DETECTIVE', '5', '12', '6'),
      ('Zvezdopad', 'Russia', '12/9/2004', '446', 'ROMANS', '5', '13', '11'),
      ('Homo Faber', 'Germany', '4/10/2022', '772','FANTASY', '3', '5', '3'),
      ('Der Richter und Sein Henker', 'Germany', '2/1/2011', '780','DETECTIVE', '3', '3', '10'),
      ('Lord of the Flies', 'United States', '7/11/2015', '900','FANTASY', '1', '2', '4'),
      ('Un soir au club', 'France', '1/12/2018', '480','DRAMA', '2', '1', '1'),
      ('Voina', 'Russia', '12/6/2004', '880',  'HISTORY', '5', '4', '13'),
      ('Sun Tzu', 'China', '9/5/2022', '349',  'HISTORY', '4', '4', '2'),


      ('Emil und die Detektive', 'Germany', '6/11/2010', '228','DETECTIVE','3', '5', '10'),
      ('Coule la Seine', 'France', '3/1/2015', '732','FANTASY', '2', '6', '1'),
      ('Love and hatred', 'Russia', '2/3/2012', '763', 'ROMANS', '5', '14', '13'),
      ('Fantastic Mr Fox', 'United States', '3/10/2018', '309','FANTASY', '1', '9', '8'),
      ('Contes de la Bécasse', 'France', '10/5/2019', '378', 'ROMANS', '2', '6', '9'),
      ('“The Death of Ivan Ilyich', 'Russia', '9/24/2000', '814','DRAMA', '5', '6', '6'),
      ('Bonjour Tristesse', 'France', '8/2/2015', '502', 'ROMANS', '2', '8', '5'),
      ('Die Verwandlung', 'Germany', '6/19/2008', '305', 'DETECTIVE','3','7', '12'),
      ('The Inspector Barlach Mysteries', 'Germany', '3/10/2007', '566','DETECTIVE', '3', '3', '3'),
      ('LÉtranger', 'France', '11/14/2017', '422', 'ROMANS', '2', '8', '5'),
      ('Lao Tse', 'China', '7/16/2005', '900','FANTASY', '4', '4', '2'),
      ('Semya', 'Russia', '4/12/2004', '194','DRAMA', '5', '13', '11'),
      ('Empty World', 'United States', '1/4/2008', '324','FANTASY', '1', '11', '15'),
      ('Domainer', 'Germany', '1/6/2020', '420', 'ROMANS', '3', '5', '10'),
      ('The Fault in Our Stars', 'United States', '2/13/2008', '396', 'ROMANS','1', '9', '4'),
      ('Die R uber', 'Germany', '6/25/2020', '300', 'ROMANS', '3', '7', '12'),
      ('Jung Chang', 'China', '5/14/2021', '600',  'HISTORY', '4', '10', '7'),
      ('Les Aventures de Tintin', 'France', '4/10/2015', '582','DRAMA', '2', '1', '5'),
      ('Unvollendete Geschichte', 'Germany', '12/12/2010', '269','DETECTIVE', '3', '5', '10'),
      ('Amy Tan', 'China', '1/9/2023', '486','DRAMA', '4', '4', '7'),
      ('Krasnaya luna', 'Russia', '2/7/2020', '550','FANTASY', '5', '12', '11'),
      ('Emma', 'United States', '10/11/2021', '599', 'BIOGRAPHY','1', '2', '15');
-- 1.Китептердин атын, чыккан жылын, жанрын чыгарыныз.
SELECT B.NAME,B.PUBLISHED_YEAR,B.GENRE FROM Book B;
-- 2.Авторлордун мамлекеттери уникалдуу чыксын.
SELECT DISTINCT A.COUNTY FROM author A;
-- 3.2020-2023 жылдардын арасындагы китептер чыксын.
SELECT * FROM Book B WHERE B.published_year BETWEEN '2020-01-01' AND '2023-01-01';
-- 4.Детектив китептер жана алардын аттары чыксын.
SELECT * FROM Book WHERE Book.GENRE = 'DETECTIVE';
-- 5.Автордун аты-жону author деген бир колонкага чыксын.
SELECT author.FIRST_NAME || ' ' || author.LAST_NAME AS AUTHOR FROM author;
SELECT concat(first_name,' ', last_name) AS AUTHOR FROM author A;
-- 6.Германия жана Франциядан болгон авторлорду толук аты-жону менен сорттоп чыгарыныз.
SELECT concat(A.first_name,' ',A.last_name) AS FIO FROM author A WHERE A.COUNTY IN ('Germany','France') ORDER BY FIO ASC ;
-- 7.Романдан башка жана баасы 500 дон кичине болгон китептердин аты, олкосу, чыккан жылы, баасы жанры чыксын..
SELECT B.NAME,B.country,B.PUBLISHED_YEAR,B.PRICE,B.GENRE FROM Book B where b.GENRE!='ROMANS' and B.price<500;
-- 8.Бардык кыз авторлордун биринчи 3 ну чыгарыныз.
SELECT * FROM author WHERE gender = 'FEMALE' LIMIT 3;
-- 9.Почтасы .com мн буткон, аты 4 тамгадан турган, кыз авторлорду чыгарыныз.
SELECT * FROM author WHERE length(first_name)= 4 AND gender = 'FEMALE' AND email LIKE ('%.com');
-- 10.Бардык олколорду жана ар бир олкодо канчадан автор бар экенин чыгаргыла.
SELECT author.county, count(author) FROM author GROUP BY county;
-- 11.Уч автор бар болгон олколорду аты мн сорттоп чыгарыныз.
SELECT  count(author) AS COLVO FROM author
                WHERE (SELECT count(author) =3 ORDER BY author.first_name ASC);
SELECT author.first_name, author.county FROM author WHERE author.county IN (SELECT county
        FROM author
        GROUP BY  county
        HAVING COUNT(*) = 3)
ORDER BY
    author.first_name ASC;
-- 12. Ар бир жанрдагы китептердин жалпы суммасын чыгарыныз
SELECT Book.GENRE, count(GENRE) AS COLVO FROM Book  GROUP BY GENRE;
-- 13. Роман жана Детектив китептеринин эн арзан бааларын чыгарыныз
SELECT genre,
    MIN(price) AS lowest_price
FROM  book
WHERE genre IN ('ROMANS', 'DETECTIVE')
GROUP BY genre;
-- 14.История жана Биографиялык китептердин сандарын чыгарыныз
SELECT Book.GENRE,count(GENRE)FROM Book WHERE GENRE IN ('HISTORY','BIOGRAPHY')
group by Book.GENRE;
-- 15.Китептердин , издательстволордун аттары жана тили чыксын
SELECT * FROM Book INNER JOIN Publisher ON  Publisher.id = Book.PUBLISHER_ID;
-- 156Авторлордун бардык маалыматтары жана издательстволору чыксын, издательство болбосо null чыксын
SELECT * FROM author LEFT JOIN book ON author.id = book.author_id
                  LEFT JOIN
              publisher ON book.publisher_id = publisher.id;
-- 17.Авторлордун толук аты-жону жана китептери чыксын, китеби жок болсо null чыксын.
SELECT * FROM author LEFT JOIN public.book b on author.id = b.author_id;
-- 18.Кайсы тилде канча китеп бар экендиги ылдыйдан ойлдого сорттолуп чыксын.
SELECT
    language.language AS book_language,
    COUNT(book.id) AS book_count
FROM book JOIN language ON book.language_id = language.id
GROUP BY book_language
ORDER BY book_count DESC;
-- 19.Издательствонун аттары жана алардын тапкан акчасынын оточо суммасы тегеректелип чыгарылсын.
SELECT Publisher.NAME,round(avg(Book.PRICE)) FROM Book INNER JOIN Publisher ON Publisher.id= Book.PUBLISHER_ID GROUP BY Publisher.NAME;
-- 20.2010-2015 жылдардын арасындагы китептер жана автордун аты-фамилиясы чыксын.
SELECT * FROM Book FULL OUTER JOIN  author ON Book.AUTHOR_ID = author.id WHERE Book.published_year BETWEEN '2010-01-01' AND '2015-12-31';
-- 21.2010-2015 жылдардын арасындагы китептердин авторлорунун толук аты-жону жана алардын тапкан акчаларынын жалпы суммасы чыксын.

SELECT author.id AS author_id, author.first_name || ' ' || author.last_name AS author_name,
    SUM(book.price) AS total_price
FROM book  JOIN  author ON book.author_id = author.id
WHERE book.published_year BETWEEN '2010-01-01' AND '2015-12-31'
GROUP BY  author.id, author_name;