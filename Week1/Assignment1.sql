create database ToursandTravels
use ToursandTravels

--Indigo airlines want to create their own software so they need to work on database first.
--They want to manage employee database as well as ticket booking system, flight details means end to end solution
--from manpower source ticket booking customer details, flight assignment including all dependencies, keys 
--and normalize your table at least 2nd normal form.

--Employee Table(emp)
create table emp(emp_id int primary key identity(101,1), emp_name nvarchar(30),DOJ date,emp_code numeric(10,0))
insert into emp values('Rahul','2013-12-12',801)
insert into emp values('Shivam','2013-10-09',802)
insert into emp values('Sarthak','2014-12-25',803)
insert into emp values('Shruti','2022-07-01',804)
insert into emp values('Shaurya','2018-12-20',907)
insert into emp values('Aditya','2021-11-12',911)
insert into emp values('Priyank','2017-05-03',807)
insert into emp values('Aditi','2022-05-10',910)
insert into emp values('Roshini','2020-12-19',903)
insert into emp values('Khushi','2022-04-25',908)

select * from emp

--Stored Procedure
create procedure sp_emp
as
begin
select emp_id, emp_code, emp_name from emp
end


exec sp_emp

--Flight Details(Flight) Table 
create table flight(flight_id int primary key identity(20,1), atime time,arrival nvarchar(20), dtime time,departure nvarchar(20), duration float, ticket_id numeric(10,0))
insert into flight values('04:13','HYD','06:13','DEL', 2, 19001)
insert into flight values('22:15','BGL','04:00','KOL', 5.45, 19002)
insert into flight values('11:15','PAT','12:30','DEL', 1.15, 19003)
insert into flight values('12:00','CHN','14:00','IXR', 2, 19004)
insert into flight values('16:30','DEL','19:15','LKO', 0.45, 19005)
insert into flight values('18:35','MAI','22:35','KOT', 4, 19006)
insert into flight values('21:45','IXR','00:00','HYD', 2.15, 19007)
insert into flight values('15:30','GUJ','19:15','MUI', 3.45, 19008)
insert into flight values('10:15','BHP','16:00','JHK', 5.45, 19009)
insert into flight values('09:00','JHK','13:00','PAT', 4, 19010)
select * from flight

--Customer Table
create table customer(cust_id int primary key identity(1001,1),name nvarchar(20),Address nvarchar(20),Mobile numeric(10,0),flight_id int,
constraint fk_flight_id  foreign key(flight_id)
references flight(flight_id))
drop table customer

insert into customer values('Ram','Bhopal',8987323,21)
insert into customer values('Shivam','Patna',2132133,23)
insert into customer values('Sarthak','Bhopal',3423112,20)
insert into customer values('Aditya','Muzzafarpur',213213,24)
insert into customer values('Saumya','Patna',8343432,21)
insert into customer values('Aditya','Delhi',9082398,27)
insert into customer values('Naman','Amritsar',6838432,28)
insert into customer values('Anuraj','Mewar',3432903,24)
insert into customer values('Shruti','Patna',3432354,22)
insert into customer values('Priya','Katra',3423463,21)
insert into customer values('Aditi','Delhi',3423409,25)
insert into customer values('Garima','Baddi',86270823,21)

select * from customer


--Flight Booking(book) Table
create table book(book_id int primary key identity(119,1),cust_id int,Customer_name nvarchar(20),Contact numeric(10,0),seat_no nvarchar(10),
constraint fk_cust_id foreign key(cust_id)
references customer(cust_id))


insert into book values (1001,'Ram',8987323,'2A')
insert into book values (1002,'Shivam',2314213,'4C')
insert into book values (1004,'Aditya',213214,'2D')
insert into book values (1003,'Sarthak',98897,'9A')
insert into book values (1008,'Anuraj',960556,'9G')
insert into book values (1007,'Naman',67657,'2K')
insert into book values (1012,'Garima',5674545,'1K')
insert into book values (1005,'Saumya',4567754,'1O')
insert into book values (1010,'Priya',6574645,'8U')
insert into book values (1009,'Shruti',8456546,'B3')
insert into book values (1006,'Aditya',8987323,'B1')
insert into book values (1011,'Aditi',889776,'1E')

select * from book
select * from customer

--Stored Procedure
create procedure sp_book_info
as
begin
select book_id, cust_id, seat_no from book
end

exec sp_book_info