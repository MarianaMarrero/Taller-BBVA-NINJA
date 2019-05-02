drop table if exists training;
CREATE TABLE training(
 id integer primary key,
 name varchar(256)
);
drop table if exists employee;
CREATE TABLE employee(
 id integer primary key,
 name varchar(256)
);

drop table if exists employee_training;
CREATE TABLE employee_training(
    id_employee integer,
    id_training integer,
  primary key(id_employee,id_training)

);