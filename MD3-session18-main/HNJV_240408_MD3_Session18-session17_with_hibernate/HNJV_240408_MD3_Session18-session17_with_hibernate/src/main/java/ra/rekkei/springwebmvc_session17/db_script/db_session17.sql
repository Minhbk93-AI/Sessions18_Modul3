create database springmvc_jv240408_session17;
use springmvc_jv240408_session17;
create table  products(
    product_id int auto_increment primary key,
    product_name varchar(100),
    producer varchar(100),
    year_making int,
    expire_date date,
    price float,
    unit_price varchar(20),
    color varchar(20),
    imageName varchar(100)
);

create table product_image(
    image_id int auto_increment primary key,
    product_id int,
    image_name varchar(100),
    foreign key (product_id) references products(product_id)
);