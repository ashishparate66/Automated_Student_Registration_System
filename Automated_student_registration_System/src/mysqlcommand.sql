create database project_automated_student;

create table student(
id int primary key auto_increment,
stdId varchar(5) unique not null,
firstName varchar(20) not null,
lastName varchar(20) not null,
address varchar(25),
mobile varchar(10), 
email varchar(20) unique not null,
password varchar(15),
course_id varchar(5) not null,
is_delete tinyint(1) DEFAULT 0
);

create table course(
id int primary key auto_increment,
courseId varchar(5) unique not null,
courseName varchar(20) not null,
courseDuration int,
fee int,
stdId int not null,
is_delete tinyint(1) DEFAULT 0,
CONSTRAINT fk_st_course FOREIGN KEY (stdId) REFERENCES student(id)
);

create table batch(
id int primary key auto_increment,
batchId varchar(5) unique not null,
batchName varchar(20) unique not null,
batchStartDate date,
batchEndDate date,
courseName varchar(20) not null,
courseId int not null,
is_delete tinyint(1) DEFAULT 0,
CONSTRAINT fk_course_batch FOREIGN KEY (courseId ) REFERENCES course(id)
CONSTRAINT fk_st_batch FOREIGN KEY (courseId ) REFERENCES student(id)

);

insert into course(courseId, courseName, CourseDuration, fee)
values
("C103","JEE",90,60000),
("C104","PHP",60,50000),
("c105","Oracle",120,150000);


=======Group by query=====
select count(*) from student s Inner Join batch b ON s.id = b.courseId group by batchName;
select count(*) from student s Inner Join course c ON s.courseId = c.id group by courseName;