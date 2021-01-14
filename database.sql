CREATE DATABASE webproject ;
use webproject;
CREATE TABLE Student (
 fname  varchar(15) not null, 
 lname    varchar(15) not null,
 sex  char not null ,
 age int not null ,
 phone varchar (11) not null, 
 username varchar(25) not null PRIMARY KEY,
 password varchar(9) not null ,
subjectone varchar(20) not null ,
subjecttwo varchar(20) not null , 
subjectthree varchar(20) not null 
);
CREATE TABLE Staff (
 fname  varchar(15) not null, 
 lname    varchar(15) not null,
 sex  char not null ,
 age int not null ,
 phone varchar (11) not null, 
 username varchar(25) not null PRIMARY KEY,
 password varchar(9) not null ,
subject varchar (25)  
);
CREATE TABLE officehours(
	meetingID int not null primary key,
	username varchar(25) not null,
    day varchar(10) not null,
    fromhours int not null,
    tohours int not null,
    state varchar(10) not null
);
CREATE TABLE messages(
    senderName varchar(25) not null,#
    receiver varchar(25) not null,
    message varchar(150) not null#
);
