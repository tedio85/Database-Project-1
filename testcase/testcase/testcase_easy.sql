CREATE TABLE Student(
	id int,
	name varchar(20),
	addr varchar(40),
	score int);

INSERT INTO STUDENT VALUES (1, 'Mark', 'Dist-1', 90);
INSERT INTO STUDENT VALUES (2, 'ark', 'Dist-2', 91);
INSERT INTO STUDENT VALUES (3, 'Mrk', 'Dist-3', 92);
INSERT INTO STUDENT VALUES (4, 'Mak', 'Dist-4', 93);
INSERT INTO STUDENT VALUES (5, 'Mar', 'Dist-5', 94);

select *
from STUDENT
where id > 3;

select s.name
from STUDENT as s;

select s.name, s.id
from Student as s
where id > 2 AND score <> 93;

