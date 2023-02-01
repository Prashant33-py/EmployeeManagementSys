use employee_details;

CREATE TABLE `employee_details`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `passwd` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


select * from employee;
select * from users;
select * from roles;
select * from user_roles;

drop table users;
drop table user_roles;
drop table roles;

insert into users (username, passwd) values ("admin","$2a$10$6LZGaLpii/SDx0VNiAFrr.adUPAthjVkShEeg/uU6w1BSwCh6OV2C");
insert into users (username, passwd) values ("user","$2a$10$6LZGaLpii/SDx0VNiAFrr.adUPAthjVkShEeg/uU6w1BSwCh6OV2C");

insert into user_roles (user_id, role_id) values (1,1);
insert into user_roles (user_id, role_id) values (1,2);
insert into user_roles (user_id, role_id) values (2,2);

insert into roles(name) values ("ROLE_ADMIN");
insert into roles(name) values ("ROLE_USER");
