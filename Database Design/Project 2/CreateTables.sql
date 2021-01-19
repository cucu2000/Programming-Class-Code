use project2;

create table Class(
ClassID char(4) not null,
ClassName varchar(40) not null, 
term char(9) not null,
primary key(ClassID));

create table Instructor(
InstructorID char(4) not null,
InstructorName varchar(40) not null,
Address varchar(40) not null,
ClassID char(4) not null,
primary key(InstructorID),
foreign key(ClassID)
references Class(ClassID)
);

create table Student(
StudentID char(4) not null,
StudentName varchar(40) not null,
Year varchar(40) not null check(Year = 'Freshman' or Year = 'Sophomore' or Year = 'Junior' or Year = 'Senior'),
Address varchar(40) not null,
Major varchar(40) not null,
ClassID char(4) not null,
primary key(StudentID),
foreign key(ClassID)
references Class (ClassID));

create table Calendar(
CalandarID char(4) not null,
Date date not null,
Event varchar(40) not null,
ClassID char(4) not null,
primary key(CalandarID),
foreign key(ClassID)
references Class(ClassID));

create table Announcements(
AnnouncementID char(4) not null,
Title varchar(30) not null,
Date date not null,
Text varchar(150) not null,
ClassID char(4) not null,
primary key(AnnouncementID),
foreign key(ClassID)
references Class(CLassID));

create table Grades(
GradesID char(4) not null,
GradedItem varchar(20) not null,
Points int not null,
Grade int not null check(Grade <= 100),
Feedback varchar(50) not null,
ClassID char(4) not null, 
StudentID char(4) not null,
primary key(GradesID),
foreign key(StudentID)
references Student(StudentID),
foreign key(ClassID)
references Class(ClassID));

create table Discussion(
DiscussionID char(4) not null,
Title varchar(30) not null,
Text varchar(150) not null,
ClassID char(4) not null,
StudentID char(4) not null,
InstructorID char(4) not null,
primary key(DiscussionID),
foreign key(StudentID)
references Student(StudentID),
foreign key(ClassID)
references Class(ClassID),
foreign key(InstructorID)
references Instructor(InstructorID));

