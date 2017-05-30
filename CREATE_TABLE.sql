CREATE TABLE employees (
	id serial NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    department_id integer NOT NULL
);

CREATE TABLE departments (
	id serial NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL
);
