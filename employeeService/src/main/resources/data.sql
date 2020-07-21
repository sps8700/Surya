--create table employee (emp_id integer not null, date_of_joining date, emp_add varchar(255), emp_name varchar(255), primary key (emp_id));
--create table vlog (vlog_id integer not null, vlog_body varchar(255), vlog_title varchar(255), employee_emp_id integer, primary key (vlog_id));

insert into employee(emp_id, date_of_joining, emp_add, emp_name) values (1001, sysdate(), 'Banglore', 'Ramesh');
insert into employee(emp_id, date_of_joining, emp_add, emp_name) values (1002, sysdate(), 'Banglore', 'John');
insert into employee(emp_id, date_of_joining, emp_add, emp_name) values (1003, sysdate(), 'Banglore', 'Suresh');

insert into vlog (vlog_id, vlog_body, vlog_title, employee_emp_id) values (1001, 'Bangalore.. How it is?', 'Bangalore', 1001);