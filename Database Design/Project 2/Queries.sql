
-- number 1 
select s.StudentID, s.ClassID, s.StudentName, g.Grade, avg(Grade) as avgGrades
from student s, grades g
where(s.StudentID = g.StudentID)
group by s.ClassID;

-- number 2 
select * from calendar;

-- number 3 
select avg(Grade) as avgGrades
from grades;

-- number 4
select i.InstructorName, i.ClassID, count(s.StudentName)
from instructor i, student s
where(i.ClassID = s.ClassID)
group by InstructorName;