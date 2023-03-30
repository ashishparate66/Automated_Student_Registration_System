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
courseId int not null,
is_delete tinyint(1) DEFAULT 0
);


insert into student(stdId,firstName,lastName,address,mobile,email,password,courseId)
VALUES
("s4","shubham","parate","gondia","4567894123","sp@gmail.com","shubham",4),
("s5","bhavesh","hedau","Nagpur","7867894123","bh@gmail.com","bhavesh",4),
("s6","harshal","awchat","banglore","8867894123","ha@gmail.com","harshal",5),
("s7","arpit","pohane","goa","9867894123","apn@gmail.com","arpit",5),
("s8","harshal","raut","kedarnath","9967894123","hr@gmail.com","harshal",6),
("s9","tanmay","chapae","delhi","6867894123","tc@gmail.com","tanmay",6)
;



create table course(
id int primary key auto_increment,
courseId varchar(5) unique not null,
courseName varchar(20) not null,
courseDuration int,
fee int,
is_delete tinyint(1) DEFAULT 0,
CONSTRAINT fk_st_course FOREIGN KEY (stdId) REFERENCES student(id)
);

insert into course(courseId, courseName, CourseDuration, fee)
values
("C103","JEE",90,60000),
("C104","PHP",60,50000),
("c105","Oracle",120,150000);


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
CONSTRAINT fk_st_batch FOREIGN KEY (courseId) REFERENCES student(id)
);

insert into batch(batchId,batchName,batchStartDate,batchEndDate,courseName,courseId)
VALUES
("B103","Android1","2023-04-15","2023-11-07","Android",1),
("B104","Android3","2023-05-15","2023-12-07","Android",1),
("B105","Java2","2023-04-15","2023-11-07","JAVA",2),
("B106","JEE1","2023-04-15","2023-07-07","JEE",3),
("B107","JEE2","2023-05-15","2023-08-10","JEE",3),
("B108","PHP1","2023-04-15","2023-06-08","PHP",4),
("B109","PHP2","2023-05-15","2023-07-08","PHP",4),
("B110","oracle1","2023-04-15","2023-08-09","Oracle",5),
("B111","oracle2","2023-05-15","2023-09-09","Oracle",5),
("B112","CSS1","2023-04-15","2023-06-09","CSS",6);




=======Group by query=====
select count(*) from student s Inner Join batch b ON s.id = b.courseId group by batchName;
select count(*) from student s Inner Join course c ON s.courseId = c.id group by courseName;

select batchName,count(*) from student s inner join course c ON s.courseId=c.id Join batch b ON b.courseId=c.id group by batchName;

 select batchName,count(batchName) from student s inner join course c ON s.courseId=c.id Join batch b ON b.courseId=c.id group by batchName;