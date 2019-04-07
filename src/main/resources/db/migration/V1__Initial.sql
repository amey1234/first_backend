CREATE TABLE if not exists `maharashtra_st`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE if not exists `maharashtra_st`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NOT NULL,
  `sur_name` VARCHAR(45) NOT NULL,
  `role_id` INT(11) NULL,
  `status` TINYINT NULL,
  `depot_id` INT(11) NULL,
  PRIMARY KEY (`id`));
  
  create table if not exists depots(id integer auto_increment, depot_name varchar(50) not null, address varchar(100) not null, pincode varchar(10) not null,
status boolean default true,
  `district_id` INT(11) NULL,primary key(id));

 CREATE TABLE if not exists `maharashtra_st`.`districts` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `district_name` VARCHAR(45) NOT NULL,
 `status` TINYINT NULL,
 PRIMARY KEY (`id`));
 
 create table if not exists bus_type(id integer auto_increment, bus_type varchar(30) not null, status boolean default true, 
 primary key(id));
 