Create table studentregistration;

use studentregistration;

create table Course( 
courseID char(8) not null,
Name varchar(100) not null,
Level int(10) not null,
primary key(courseID)
);

create table Instructor(
instructorID char(5) not null,
fName varchar(25) not null,
lName varchar(25) not null,
officeNumber varchar(25),
email varchar(25),
phone varchar(25),
primary key(instructorID)
);

create table CourseInstructor(
courseID char(8) not null,
instructorID char(5) not null,
semester varchar(25) not null,
year int(10) not null,
room int(10) not null,
startDate date not null,
endDate date not null,
startTime time not null,
endTime time not null,
maxStudents int(10) not null,
primary key(courseID),
foreign key(instructorID)
references Instructor (instructorID)
on delete cascade 
);

create table Student(
studentID char(10) not null,
fName varchar(25) not null,
lName varchar(25) not null,
major varchar(25) not null,
year varchar(25) not null,
email varchar(25),
phone varchar(25),
primary key(studentID)
);

create table CourseInstructorStudent(
courseID char(8),
instructorID char(8),
studentID char(8),
foreign key (courseID)
references Course (courseID)
on delete cascade, 
foreign key (instructorID)
references Instructor  (instructorID)
on delete cascade, 
foreign key (studentID)
references Student (studentID)
on delete cascade
);