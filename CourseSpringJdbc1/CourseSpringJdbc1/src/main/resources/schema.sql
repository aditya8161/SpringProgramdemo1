create table if not exists categories1(
    categoryId int primary key,
    title varchar(50) not null,
    description varchar(100) not null
);

create table if not exists course1(
    courseId int primary key,
    name varchar(30) not null,
    description varchar(100) not null,
    price int not null,
    catId int,

    foreign key(catId) references categories1(categoryId)
);
