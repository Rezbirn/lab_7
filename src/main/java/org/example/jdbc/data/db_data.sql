DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS
(
    user_id     INT PRIMARY KEY AUTO_INCREMENT,
    first_name  VARCHAR(250),
    family_name VARCHAR(250),
    email       VARCHAR(250) NOT NULL,
    password    VARCHAR(250) NOT NULL
);

insert into users (user_id, first_name, family_name, email, password) values (default, 'Vasya', 'Pupkin', 'pupkin@gmail.com', '123456');
insert into users (user_id, first_name, family_name, email, password) values (default, 'Masha', 'Pupkina', 'pupkina@gmail.com', '123456789');
