CREATE TABLE Student (
	v int, a varchar(20)
);

INSERT Into Student 
Values (1, 'a');

INSERT Into Student 
Values (2, 'c');

INSERT Into Student 
Values (59, 'b');

INSERT Into Student 
Values (1240, 'd');

INSERT Into Student 
Values (3423, 'e');

SELECT v 
FROM Student
WHERE a = 'a';