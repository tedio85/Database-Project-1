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

SELECT *
FROM STUDENT
WHERE id > 3;


