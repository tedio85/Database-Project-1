CREATE TABLE Student (
	v int, a varchar(20)
);

CREATE TABLE Label (
	c int, d varchar(20)
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
Values (3423, 'a');

INSERT Into Label 
Values (1, 'a');

INSERT Into Label 
Values (3, 'a');

INSERT Into Label 
Values (5, 'b');

SELECT a
FROM Student, Label
WHERE a = d AND d = 'a';