use project2;

insert into class values('M001', 'Calculus 1', '2019-2020');
insert into class values('S001', 'Biology 1', '2019-2020');
insert into class values('M002', 'Calculus 2', '2019-2020');
insert into class values('S002', 'Biology 1', '2019-2020');
insert into class values('P001', 'Programming 1', '2019-2020');

insert into announcements values('A001', 'No Class Tommorow', date(10/13/2020), 'No class tommorow do your homework', 'M001');
insert into announcements values('A002', 'Project 2 due tommorow', date(10/18/2020), 'Remember Project 2 is due tommorrow', 'P001');
insert into announcements values('A003', 'Exam 2', date(10/16/2020), 'Exam 2 is next week', 'M001');
insert into announcements values('A004', 'Homework E', date(10/9/2020), 'HW E was posted it is due 10/12/20', 'M002');
insert into announcements values('A005', 'Lab', date(10/15/2020), 'Lab  tommorow', 'S002');

insert into calendar values('C001', 10/14/2020, 'No class', 'M001');
insert into calendar values('C002', 10/19/2020, 'Project 2 due date', 'P001');
insert into calendar values('C003', 10/23/2020, 'Exam 2', 'M001');
insert into calendar values('C004', 10/19/2020, 'Hw E due date', 'M002');
insert into calendar values('C005', 10/16/2020, 'Lab', 'S002');

insert into instructor values('T001', 'Tavakoli', ' 123 Street, Ok City, OK', 'M001');
insert into instructor values('T002', 'Tavakoli', ' 123 Street, Ok City, OK', 'M002');
insert into instructor values('T003', 'Jeff Maxwell', ' 234 Street, Ok City, OK', 'P001');
insert into instructor values('T004', 'Matt Welch', ' 456 Street, Tuttle, OK', 'S001');
insert into instructor values('T005', 'Crystal Neasbitt', ' 654 Street, Tuttle, OK', 'S002');

insert into student values('St01', 'Kaleb Cosgrave', 'Sophomore', '552 Street, Tuttle, OK', 'Compuster Science', 'P001');
insert into student values('St02', 'Jane Doe', 'Freshman', '565 Street, Ok City, OK', 'Biology', 'S001');
insert into student values('St03', 'Bob Moore', 'Freshman', '865 Street, Tulsa, OK', 'Mathmatics', 'M001');
insert into student values('St04', 'Dan Shihan', 'Junior', '346 Street, Newcastle, OK', 'Computer Science', 'M002');
insert into student values('St05', 'Jenny Miller', 'Senior', '987 Street, Blanchard, OK', 'Biology', 'S002');

insert into discussion values('D001', 'Hw Help', 'A place to discuss to ask for help on homework assignments', 'M001', 'St03', 'T001');
insert into discussion values('D002', 'Hw Help', 'A place to discuss to ask for help on homework assignments', 'M002', 'St04', 'T002');
insert into discussion values('D003', 'Interesting Topics', 'Topics that would be interesting to discuss in class', 'P001', 'St04', 'T003');
insert into discussion values('D004', 'Lab Discussion', 'A place to discuss Labs we did in class', 'S001', 'St02', 'T004');
insert into discussion values('D005', 'Lab Discussion', 'A place to discuss Labs we did in class', 'S002', 'St05', 'T005');

insert into grades values('G001', 'Exam 1', '50', '100', 'Good Work', 'M001',  'St03');
insert into grades values('G002', 'Project 2', '75', '95', 'Feedback Posted', 'P001',  'St01');
insert into grades values('G003', 'Hw D', '10', '50', 'Take another look', 'M002',  'St04');
insert into grades values('G004', 'Lab 1', '100', '85', ' ', 'S002',  'St05');
insert into grades values('G005', 'HW A', '10', '90', 'Mostly Right look at #2 again', 'S001',  'St02');

 select * from class;
 select * from announcements;
 select * from calendar;
select * from instructor;
select * from student;
select * from discussion;
select * from grades;