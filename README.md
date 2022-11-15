# Automatic Student Registration System
A java application built to manage student details at an institution. The application is built using Java, JDBC and MySQL. 
This application can be used to perform following operations:

For Administrator:
* Add a new Courses
* Update Fees of course.
* Delete  a course from any Training session.
* Search information about a course.
* Create Batch under a course.
* Allocate students in a Batch under a course.
* Update total seats of a batch.
* View the students of every batch. 

For Student:
* Register with a username and password.
* Update profile details.
* See all the available course list and their seat availability.



## Prerequisites
1. java jdk 1.8 or above
2. [JDBC connector](https://dev.mysql.com/downloads/connector/j/)
3. mySQL database with following tables and their structure:


  * Student Table 
    mysql> create table student(
    roll int primary key auto_increment,
    name varchar(30) not null,
    email varchar(30) unique not null,
    password varchar(30) not null,
    coursename varchar(20) not null
    );
    
  * Course Table: 
    mysql>create table course(
    cid int primary key auto_increment,
    cname varchar(12),
    batch int, 
    fee int,
    totalseats int
    );  
    
  * Course_Student Table:
    create table course_student(
    cid int,
    roll int,
    foreign key (cid) references course(cid),
    foreign key (roll) references student(roll)
    );
    
    //to cascade delete;

  * alter table course_student
    add constraint cid
    foreign key(cid)
    references course(cid)
    on delete cascade;
    
  * Admin Table:
    create table admin(
    username varchar(15),
    password varchar(15)
    ); 
    
  * insert into admin values('admin','admin');
    

## Important guidelines
1. Add mySQL user and password details in the "conn = DriverManager.getConnection(url, "root", "sqlpass");" statement in DBUtil.java file inside utility package.
2. Start the application from Main.java file under main package.
3. The database name by default is 'projectdb' and tables are 'student', 'course', 'course_student' and 'admin'.
