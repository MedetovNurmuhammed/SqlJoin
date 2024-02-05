create table programmers(id_prog serial primary key ,firstName varchar,last_name varchar, date_of_birth date,gender varchar, email varchar,programming_language varchar, experience int,salary int,phone_number varchar);
create table companies (id_company serial primary key ,name varchar,rating double precision,address_id integer references  addresses(id_addresses));
create table  projects (id_projects serial primary key ,title varchar,description varchar,start_date date,company_id integer references companies(id_company));
create table  projects_programmers(project_id int,programmers_id integer references  programmers(id_prog));
create table addresses(id_addresses serial primary key ,country varchar,city varchar,street varchar);
select * from projects_programmers;
-- Insert into addresses
INSERT INTO addresses (country, city, street)
VALUES ('USA', 'New York', 'Broadway'),
       ('Kyrgyzstan', 'Bishkek', 'Chuy Avenue'),
       ('Germany', 'Berlin', 'Unter den Linden'),
       ('France', 'Paris', 'Champs-Élysées'),
       ('Kazakhstan', 'Nur-Sultan', 'Nurzhol Boulevard'),
       ('China', 'Beijing', 'Tiananmen Square'),
       ('Ukraine', 'Kyiv', 'Khreshchatyk Street'),
       ('Italy', 'Rome', 'Via del Corso'),
       ('Russia', 'Moscow', 'Red Square');

-- Insert into companies
INSERT INTO companies (name, rating, address_id)
VALUES ('Google', 4.5, 1),
       ('Oracle', 4.2, 2),
       ('Peaksoft', 4.8, 3),
       ('FaceBook', 3.9, 4),
       ('Amazon', 4.6, 5),
       ('Microsoft', 4.7, 6),
       ('Apple', 4.4, 7),
       ('Yandex', 4.9, 8),
       ('Mad devs', 3.8, 9),
       ('Beeline', 4.1, 9);

-- Insert into projects
-- Create table projects
create table if not exists projects
(
    id          serial primary key,
    title       varchar,
    description varchar(1000),
    start_date  date,
    company_id  int references companies (id_company)
);

-- Insert into projects
INSERT INTO projects (title, description, start_date, company_id)
VALUES ('Weather App', 'A simple weather application', '2023-01-01', 1),
       ('Quiz App', 'An interactive quiz application', '2022-02-15', 2),
       ('Stopwatch App', 'A basic stopwatch application', '2023-03-10', 3),
       ('Landing Page', 'A landing page for a product', '2019-04-05', 4),
       ('Portfolio Website', 'A personal portfolio website', '2010-05-20', 5),
       ('QR Code Reader', 'An app to read QR codes', '20217-06-15', 6),
       ('To-do List', 'A simple to-do list application', '2023-07-01', 7),
       ('Password Generator', 'A tool to generate passwords', '2023-08-10', 8),
       ('Charity donation Platform', 'A platform for charity donations', '2020-09-25', 9),
       ('Note App', 'An application for taking notes', '2021-10-15', 10),
       ('Meme Generator', 'Create memes with this app', '2019-11-01', 1),
       ('Food Order Website', 'Order your favorite food online', '2023-12-05', 2),
       ('Dating Website', 'Connect with new people', '2024-01-10', 3),
       ('Survey App', 'Collect feedback and opinions', '2024-02-15', 4),
       ('Link Shortener Website', 'Shorten and share links', '2024-03-20', 5),
       ('Movie App', 'Discover and watch movies', '2016-04-25', 6),
       ('Hotel Booking Website', 'Book hotels for your stay', '2015-05-30', 7),
       ('Random User API', 'Generate random user data', '2016-06-05', 8),
       ('Travelling Booking Website', 'Plan your travel itinerary', '2024-07-10', 9),
       ('Resume Builder', 'Create professional resumes', '2022-08-15', 10),
       ('Recipe and meal planning website', 'Discover and plan meals', '2020-09-20', 1),
       ('College or university course catalog and registration website', 'Explore and register for courses',
        '2018-10-25', 2),
       ('Real estate listing website', 'Browse and find real estate listings', '2023-11-30', 3),
       ('Recipe website with user-submitted content', 'Share and discover recipes', '2025-01-05', 4),
       ('Fitness or health tracking app', 'Track your fitness and health goals', '2025-02-10', 5),
       ('Tic Tac Toe Game', 'Classic game of Tic Tac Toe', '2019-03-15', 6),
       ('Chess Game', 'Play chess against opponents', '2025-04-20', 7),
       ('Parallax Website', 'Create visually appealing parallax websites', '2023-05-25', 8),
       ('E-Book Site', 'Discover and read e-books', '2025-06-30', 9),
       ('Task management or productivity tool', 'Stay organized and productive', '2025-07-05', 10),
       ('A marketplace for buying and selling goods or services', 'Connect buyers and sellers', '2024-08-10', 1),
       ('An educational platform or online course website', 'Learn new skills online', '2011-09-15', 2),
       ('Financial management or budgeting tool', 'Manage your finances', '2000-10-20', 3),
       ('A job board or career website', 'Find and apply for jobs', '2000-11-25', 4),
       ('Twitter Clone', 'Social media platform like Twitter', '2026-01-01', 5),
       ('Instagram Clone', 'Photo-sharing app like Instagram', '2026-02-05', 6),
       ('Youtube Clone', 'Video-sharing platform like Youtube', '2020-03-10', 7),
       ('Whatsapp Clone', 'Messaging app like Whatsapp', '2018-04-15', 8),
       ('Netflix Clone', 'Streaming service like Netflix', '2017-05-20', 9),
       ('Giphy Clone', 'Search and share animated GIFs', '2024-06-25', 10),
       ('Typing Speed Website', 'Improve your typing speed', '2023-07-30', 1),
       ('File Sharing App', 'Share files securely', '2022-08-05', 2),
       ('Music Player', 'Listen to your favorite music', '2026-09-10', 3);

-- Insert into programmers
INSERT INTO programmers (firstName, last_name, date_of_birth, gender, email, programming_language, experience, salary, phone_number)
VALUES
    ('Nurislam', 'Toigonbaev', '1998-05-15', 'Male', 'nurislam@email.com', 'Java', 5, 60000.00, '+996701234567'),
    ('Nurlan', 'Abibilaev', '2003-09-22', 'Male', 'nurlan@email.com', 'Python', 3, 55000.50, '+996702345678'),
    ('Gulumkan', 'Uson kyzy', '2002-03-10', 'Female', 'gulumkan@email.com', 'JavaScript', 2, 50000.75, '+996703456789'),
    ('Baha', 'Zharkinbaev', '2001-12-05', 'Male', 'baha@email.com', 'C#', 4, 62000.25, '+996704567890'),
    ('Mirlan', 'Arstanbekov', '2002-06-18', 'Male', 'mirlan@email.com', 'Ruby', 6, 70000.00, '+996705678901'),
    ('Nurtaazim', 'Mukanov', '2004-01-30', 'Male', 'nurtaazim@email.com', 'C++', 1, 48000.00, '+996706789012'),
    ('Aliaskar', 'Temirbekov', '2000-11-12', 'Male', 'aliaskar@email.com', 'Java', 7, 75000.00, '+996707890123'),
    ('Zhigit', 'Turumbekov', '2001-07-25', 'Male', 'zhigit@email.com', 'Python', 5, 60000.50, '+996708901234'),
    ('Aiturgan', 'Maksatbek kyzy', '2004-04-08', 'Female', 'aiturgan@email.com', 'JavaScript', 3, 55000.75, '+996709012345'),
    ('Nurmukhammed', 'Medetov', '2000-09-19', 'Male', 'nurmukhammed@email.com', 'C#', 2, 50000.00, '+996709876543'),
    ('Nurkamil', 'Kamchyev', '1997-12-03', 'Male', 'nurkamil@email.com', 'Ruby', 4, 62000.50, '+996708765432'),
    ('Muktarbek', 'Elebesov', '2005-05-28', 'Male', 'muktarbek@email.com', 'C++', 6, 70000.25, '+996707654321'),
    ('Urmat', 'Taichikov', '1998-08-15', 'Male', 'urmat@email.com', 'Java', 1, 48000.50, '+996706543210'),
    ('Myrzaiym', 'Keldibekova', '2003-11-02', 'Female', 'myrzaiym@email.com', 'Python', 7, 75000.50, '+996705432109'),
    ('Nurgazy', 'Temiraliev', '1995-02-14', 'Male', 'nurgazy@email.com', 'JavaScript', 5, 60000.75, '+996704321098'),
    ('Adyl', 'Tolomushov', '2006-05-21', 'Male', 'adyl@email.com', 'C#', 3, 55000.00, '+996703210987'),
    ('Abdurashid', 'Jusupov', '199-10-09', 'Male', 'abdurashid@email.com', 'Ruby', 2, 50000.25, '+996702109876'),
    ('Zeinep', 'Alapaeva', '1997-03-28', 'Female', 'zeinep@email.com', 'C++', 4, 62000.75, '+996701098765'),
    ('Zaripbek', 'Dushoev', '1999-06-15', 'Male', 'zaripbek@email.com', 'Java', 6, 70000.50, '+996701987654'),
    ('Ajybek', 'Sadykov', '2008-09-01', 'Male', 'ajybek@email.com', 'Python', 1, 48000.75, '+996702876543'),
    ('Nurmukhammed', 'Rusbaev', '2007-02-18', 'Male', 'nurmukhammedm@email.com', 'JavaScript', 7, 75000.75, '+996703765432'),
    ('Nurtilek', 'Abdippataev', '1995-07-11', 'Male', 'nurtilek@email.com', 'C#', 5, 60000.00, '+996704654321'),
    ('Nuraida', 'Myrzalim kyzy', '2005-12-30', 'Female', 'nuraida@email.com', 'Ruby', 3, 55000.25, '+996705543210'),
    ('Kandybek', 'Isaev', '1990-03-17', 'Male', 'kandybek@email.com', 'C++', 2, 50000.50, '+996706432109'),
    ('Jandar', 'Taalaibekov', '1998-06-24', 'Male', 'jandar@email.com', 'Java', 4, 62000.00, '+996707321098'),
    ('Baktygul', 'Jumagazy kyzy', '2000-09-09', 'Female', 'baktygul@email.com', 'Python', 6, 70000.25, '+996708210987');

-- Insert into projects_programmers
INSERT INTO projects_programmers (project_id, programmers_id)
VALUES
-- Assigning programmers to projects
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
(6, 6), (7, 7), (8, 8), (9, 9), (10, 10),
(11, 11), (12, 12), (13, 13), (14, 14), (15, 15),
(16, 16), (17, 17), (18, 18), (19, 19), (20, 20),
(21, 21), (22, 22), (23, 23), (24, 24), (25, 25),
(26, 26), (1, 2), (2, 3), (3, 4), (4, 5),
(5, 6), (6, 7), (7, 8), (8, 9), (9, 10),
(10, 11), (11, 12), (12, 13), (13, 14), (14, 15),
(15, 16), (16, 17), (17, 18), (18, 19), (19, 20),
(20, 21), (21, 22), (22, 23), (23, 24), (24, 25),
(25, 26), (26, 1);
insert into companies(name, rating) values ('Nurdev',7);
insert into addresses(country, city, street) values ('Кыргызстан','Тюп','Долон');
--cross join
select c.id_company, c.name, p.id_prog,p.firstName from  companies c cross join programmers p;
select * from programmers cross join projects;
--inner
select  * from  companies inner join  addresses on  companies.address_id = addresses.id_addresses;
--outer join
select * from companies  c right outer join addresses a on c.address_id = a.id_addresses;
--Practice:
-- Бардык проект аталыштарын жана тиешелүү компаниянын аталыштарын алыңыз . Перечислите все названия
-- проектов и соответствующие названия компаний.
select projects.title,companies.name from projects inner join companies on projects.company_id = companies.id_company;

-- США-да жайгашкан компаниялардын аталыштарын жана даректерин алыңыз. Получите названия и адреса компаний, расположенных в США.
select * from companies c inner join addresses a on c.id_company = a.id_addresses where country = 'USA';

-- Weather App долбоорунда иштеген программисттерди алыныз. Найдите программистов, работавших над проектом «Weather App».
select * from programmers p1 inner join projects p2 on p1.id_prog = p2.id_projects where p2.title = 'Weather App';
-- Бардык проекттерди жана алар боюнча иштеген программисттерди,
-- анын ичинде эч кандай программисттер дайындалбаган проекттерди алыныз.
select * from projects p1 left join programmers p2  on p1.id_projects = p2.id_prog;
-- Перечислите все проекты и программистов,
-- работающих над ними, включая проекты, для которых не назначены программисты.
select projects.id_projects, projects.title as project_title,
       programmers.id_prog as programmer_id,
       programmers.firstName || ' ' || programmers.last_name as programmer_name
from projects
         left  join projects_programmers on projects.id_projects = projects_programmers.project_id
         left join programmers on projects_programmers.programmers_id = programmers.id_prog;

-- Ар бир программалоо тили үчүн программисттердин жалпы санын алыңыз. Получите общее
-- количество программистов для каждого языка программирования.
select programming_language, count(*) as total_programmers
from programmers
group by programming_language;

-- Программисттердин 4 жылдан ашык тажрыйбасы бар программисттерди жана проекттерди алыныз. Найдите проекты и программистов,
-- где программисты имеют опыт работы более 4 лет.
select * from programmers inner join  projects on programmers.id_prog = projects.id_projects where programmers.experience>4;

-- Бардык компанияларды жана алардын проектерин, анын ичинде проект жок компанияларды алыныз. Перечислите все компании
-- и их проекты, включая компании без проектов.
select * from companies full join projects on companies.id_company = projects.company_id;
-- Рейтинги 4,5тен жогору болгон компаниялар үчүн проектерди жана башталуу күндөрүн алыңыз. Получите проекты и даты их начала
-- для компаний с рейтингом выше 4,5.
select projects.title,projects.start_date ,* from companies inner join projects on companies.id_company = projects.company_id where companies.rating>4.5;
-- Айымдар иштеген проекти жана программисттерди алыныз. Найдите проекты и программистов, где программисты — женщины.
select * from projects inner join programmers on projects.id_projects = programmers.id_prog where programmers.gender = 'Female';
-- Программисттери жок проекттерди алыңыз. Получите проекты, для которых не назначены программисты.
select *
from projects
         left  join projects_programmers on projects.id_projects = projects_programmers.project_id
where projects_programmers.project_id is null;

