CREATE TABLE Student(
	id int,
	name varchar(20),
	dept varchar(40),
	score int);

CREATE TABLE Dept(
	id int,
	name varchar(20),
	location varchar(40)
);

INSERT INTO STUDENT VALUES (1, 'A', 'ECON', 90);
INSERT INTO STUDENT VALUES (2, 'AB', 'EE', 91);
INSERT INTO STUDENT VALUES (3, 'B', 'FL', 92);
INSERT INTO STUDENT VALUES (4, 'BC', 'MATH', 93);
INSERT INTO STUDENT VALUES (5, 'CD', 'CS', 94);
INSERT INTO STUDENT VALUES (6, 'D', 'LS', 93);
INSERT INTO STUDENT VALUES (7, 'E', 'ECON', 78);
INSERT INTO STUDENT VALUES (8, 'F', 'EE', 97);
INSERT INTO STUDENT VALUES (9, 'G', 'FL', 87);
INSERT INTO STUDENT VALUES (10, 'H', 'CS', 95);
INSERT INTO STUDENT VALUES (11, 'I', 'LS', 83);
INSERT INTO STUDENT VALUES (12, 'J', 'MATH', 96);
INSERT INTO STUDENT VALUES (96, 'J', 'MATH', 96);


INSERT INTO DEPT VALUES (1, 'CS', 'downhill');
INSERT INTO DEPT VALUES (2, 'EE', 'downhill');
INSERT INTO DEPT VALUES (3, 'ECON', 'uphill');
INSERT INTO DEPT VALUES (4, 'MATH', 'downhill');
INSERT INTO DEPT VALUES (5, 'LS', 'uphill');
INSERT INTO DEPT VALUES (6, 'FL', 'uphill');

select *
from STUDENT
where id > 3;

select s.name
from STUDENT as s;

select s.name, s.id
from Student as s
where id > 2 AND score <> 93;

select *
from Student as s, DEPT as d
where  s.dept = d.name;

select *
from Student as s, DEPT as d
where  s.dept = d.name AND d.location = 'downhill';

select COUNT(*)
from Student as s, DEPT as d
where  s.dept = d.name AND d.location = 'downhill';

select COUNT(s.name)
from Student as s, DEPT as d
where  s.dept = d.name AND d.location = 'downhill';

select SUM(s.name)
from Student as s, DEPT as d
where  s.dept = d.name AND d.location = 'downhill';

select SUM(s.id)
from Student as s, DEPT as d
where  s.dept = d.name AND d.location = 'downhill';

select *
from Student as s, DEPT
where  s.id = s.score;