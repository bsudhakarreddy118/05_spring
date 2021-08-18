-- DDL
create database if not exists demo_db;
show databases;
use demo_db;

select database();

-- create a table
show tables;
create table customer(
	id int primary key auto_increment,
    cust_name varchar(30) not null,
    regd_date date,
    age int,
    mobile bigint
);

describe customer;

-- Deleting the whole table
drop table if exists customer;

alter table customer add column text varchar(20);

alter table customer add column city varchar(20);

drop table customer;

drop database demo_db;


-- DML Commands
-- inserting a row in a table

INSERT into customer values(1,'john', '2000-01-01',25, 9999911111);

INSERT into customer(cust_name, regd_date, age, mobile) values('dave', '2000-01-01',25, 9999911112);
INSERT into customer(cust_name, regd_date, age, mobile) values('cathy', '2001-01-01',24, 999991113);
INSERT into customer(cust_name, regd_date, age, mobile) values('bob', '2002-01-01',26, 9999911114);
INSERT into customer(cust_name, regd_date, age, mobile) values('mike', '2003-01-01',28, 9999911115);

INSERT into customer(cust_name, regd_date, age, mobile) values('don', '2000-01-02',24, 9999911112);
INSERT into customer(cust_name, regd_date, age, mobile) values('cindy', '2001-01-02',23, 999991113);
INSERT into customer(cust_name, regd_date, age, mobile) values('binny', '2002-01-02',22, 9999911114);
INSERT into customer(cust_name, regd_date, age, mobile) values('mathew', '2003-01-02',21, 9999911115);


select * from customer;

update customer set city='Bangalore' where city is null;

update customer set mobile=9999955555 where id = 9;

delete from customer where mobile=9999955555 ;

-- selections and projections

select * from customer where age > 24 and city = 'Bangalore';

select cust_name, mobile from customer 
	where city = 'Bangalore'
    order by age desc, name asc;
    
select * from customer where cust_name like 'd%';

-- aggregate functions avg, count, max, min, sum

-- average age of customers in bangalore
select avg(age) from customer where city = 'Bangalore';
select count(*) from customer where city = 'Mangalore';
select max(age) from customer where city = 'Bangalore';

-- group by 
-- count of customer by city

select city as location, count(*) as cust_count from customer
group by city
having cust_count >= 3;

-- Name of the customer in Bangalore with Maximum age

select cust_name, age from customer 
	where city = 'Bangalore' 
    and age IN (
    select max(age) from customer where city = 'Bangalore'
    );

-- find out the name of the customers regd in 2000

select cust_name from customer where regd_date
between '2000-01-01' and '2000-12-31';

select CONCAT(UPPER(cust_name),age) from customer where YEAR(regd_date) = 2000;

create table orders(
	order_id int primary key,
    order_date date not null,
    order_amount decimal(8,2),
    order_status varchar(20),
    cust_id int,
    foreign key orders(cust_id) references customer(id)
);

insert into orders values(101, '2020-05-01', 10000.50, 'shipped', 1);
-- Error Code: 1452. Cannot add or update a child row: 
-- a foreign key constraint fails (`demo_db`.`orders`, CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`id`))
insert into orders values(102, '2020-05-01', 10000.50, 'shipped', 55);

insert into orders values(102, '2020-05-01', 10000.50, 'shipped', 1);
insert into orders values(103, '2020-05-02', 20000.50, 'packed', 2);
insert into orders values(104, '2020-05-03', 30000.50, 'shipped', 1);
insert into orders values(105, '2020-05-04', 5000.50, 'delivered', 2);
insert into orders values(106, '2020-05-05', 2000.50, 'shipped', 3);

-- Name of the customers with the orders they have placed with order amount

select  ord.order_id, ord.order_amount, cust.cust_name
from orders as ord inner join customer as cust
on ord.cust_id = cust.id;
-- where ord.order_status = 'delivered';

























