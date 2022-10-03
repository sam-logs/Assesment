create database dbdphonecorp;
use dbdphonecorp;
drop database dbdphonecorp;

--  User Table
create table Users(userId int auto_increment primary key, firstName varchar(20), lastName varchar(20),
address varchar(30), mobile numeric, email varchar(25), userName varchar(30), passwords varchar(12), referralPoints int);

 drop table Users;
select * from Users;

insert into Users values(101,"Ram", "Kumar", "Pune", 7645833, "ram@gmail.com", "Userram", "Ram@123",0);
insert into Users values(102,"Sikha", "Sharma", "Chandigarh", 987362, "shikha@gmail.com", "Usersikha", "Sikha@123",0);
insert into Users values(103,"Shruti", "Thakur", "Jammu", 083232, "Shruti@gmail.com", "Usershruti", "Shruti@123",0);
insert into Users values(104,"Shivam", "Kumar", "Patna", 123432, "Shivam@gmail.com", "Usershiv", "Shiv@123",0);
insert into Users values(105,"Aditya", "", "Muzzafarpur", 9876321, "aditya@gmail.com", "Useradi", "Adi@123",0);


-- Referral Table
create table Referral( referalId int auto_increment primary key, referralFirstName varchar(20), referralLastName varchar(20),
 mobile numeric, email varchar(20), userId int,  constraint fk_user foreign key(userId)
 references users(userId), dateOfReferral date, statusOfReferral varchar(10));
 
  drop table Referral;
  select * from referral;
  
 insert into Referral values(237, "Ankit","Kumar", 987432, "Ankit@123",101, '2022-07-19', "inactive");
 insert into Referral values(238, "Mathew","Paul", 092132, "Mathew@123",103, '2022-08-16', "inactive");
 insert into Referral values(239, "Sara","Hades", 876329, "Sara@123",104, '2022-09-12', "inactive");
 insert into Referral values(240, "Shivangi","Kumari", 9821332, "Shivangi@123",102, '2022-07-20', "inactive");
 insert into Referral values(241,"Rohit","Kumar", 9826132, "Rohit@123",103, '2022-09-08', "inactive");
 insert into Referral values(242,"Jack","Daniel", 098721, "Jack@123",103, '2022-08-10', "inactive");
 insert into Referral values(243,"Rohit","Kumar", 9826132, "Rohit@123",103, '2022-09-11', "inactive");
 
 
 -- Customer Table
 create table Customer(customerId int auto_increment primary key, firstName varchar(20), lastName varchar(20), 
 email varchar(25), mobile numeric);
 
  drop table Customer;
 
 insert into Customer values(901, "Virat", "Kohli", "Virat@gmail.com",921893);
  insert into Customer values(902, "Arjun", "", "Arjun@gmail.com",768213);
  insert into Customer values(903, "Varsha", "Aggrwal", "Varsha@gmail.com",9218956);
  insert into Customer values(904, "Ashwin", "Kumar", "Ashwin@gmail.com",872132);
  insert into Customer values(905, "Sam", "", "Sam@gmail.com",9823213);
  insert into Customer values(906, "Rahul", "Raj", "Raja@gmail.com",4352718);
  insert into Customer values(907, "Shikha", "Bansal", "Sikha@gmail.com",2139213);
  select * from Customer;   
 
 -- Transaction Table
 create table BuyingDetails( customerId int, constraint fk_customer foreign key(customerId) 
 references Customer(customerId) on delete cascade, usersId int, constraint fk_userTransaction foreign key(usersId)
 references users(userId) on delete cascade, purchaseDate date, productName varchar(20));
 
 drop table BuyingDetails;
 
 insert into BuyingDetails values(901, 102, '2022-08-19', "RealmeNarzo");
 insert into BuyingDetails values(902, 101, '2022-07-13', "Iphone13");
 insert into BuyingDetails values(903, 103, '2022-09-21', "Iphone14");
 insert into BuyingDetails values(904, 104, '2022-09-25', "Iphone14");
 insert into BuyingDetails values(905, 103, '2022-08-17', "PocoX3Pro");
 insert into BuyingDetails values(906, 103, '2022-08-15', "OnePlus");
 insert into BuyingDetails values(907, 101, '2022-09-21', "Samsung S22");
     
  select * from BuyingDetails;   
     
 -- trigger for referral point update
 create trigger referral_point_update 
 after insert
 on BuyingDetails 
 for each row
 update Users 
 set referralPoints = referralPoints + 1000
 where userId = new.usersId;

-- 
 create trigger referral_status_update 
 after insert
 on BuyingDetails 
 for each row
 update referral 
 set statusOfReferral = "active"
 where userId = new.usersId;
 
 drop trigger referral_status_update;



-- Display total number of referral done by particular user by userId.
select count(userId) from Referral where userId = 103;

-- Display name and mobile of user whose referral customer have purchased item on 21/09/2022
select firstName,lastName,mobile from Customer c
right join BuyingDetails b
using(customerId)
where purchaseDate = '2022-09-21';

-- Display details of customer who purchased “iPhone 14”
select * from customer c 
inner join
BuyingDetails b 
using(customerId)
where productName = "Iphone14";

-- delete all record of customer including purchase details Those have purchased iPhone 14.
delete Customer,BuyingDetails from Customer c
inner join
BuyingDetails b
on c.customerId = b.customerId
where productName = "Iphone14";

/* Write userview to display only first name, last name, mobile and email. And 

Perform following queries on view
-Display record by email
-Display record by mobile
*/

create view userview as
select firstName, lastName, mobile, email from users;

select email from userview group by email;
select mobile from userview group by mobile;