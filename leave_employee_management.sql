create database if not exists leave_employee_management;

use leave_employee_management;

create table if not exists manager(
manager_id int auto_increment primary key,
email varchar(255) not null unique check (email like '%_@_%._%'),
name varchar(50) not null);

create table if not exists employee
(emp_id int auto_increment primary key, 
name varchar(50) not null, 
email varchar(255) not null unique check (email like '%_@_%._%'), 
department varchar(100) not null);

alter table employee 
add column manager_id int;

alter table employee 
add constraint fk_employee_manager 
foreign key (manager_id)
references manager(manager_id);

create table if not exists leave_request(
leave_id int auto_increment primary key, 
emp_id int not null,
leave_type varchar(75) default 'annual leave',
start_date date not null,
end_date date not null,
reason varchar(120) check (length(reason) >= 5) default 'personal reasons' ,
leave_status enum('pending','approved','rejected') default 'pending',
foreign key (emp_id) references employee(emp_id));

alter table leave_request
add column remark varchar(250) null;

select * from leave_request;
select * from employee;
select * from manager;