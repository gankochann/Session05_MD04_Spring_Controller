create database mvc_student;
use mvc_student;

create table student(
    id int auto_increment primary key ,
    name varchar(200) not null ,
    email varchar(200) not null ,
    birthday date not null ,
    avgMark double not null
);

DELIMITER //
create procedure find_add()
begin
    select * from student;
end //
DELIMITER ;

DELIMITER //
create procedure add_student(
    name_in varchar(200),
    email_in varchar(200),
    birth_in date,
    avg_in double
)
begin
    insert into student(name, email, birthday, avgMark)
        values (name_in,email_in,birth_in,avg_in);
end //
DELIMITER ;

DELIMITER //
create procedure update_student(
    id_in int ,
    name_in varchar(200),
    email_in varchar(200),
    birth_in date,
    avg_in double
)
begin
    update student
        set name = name_in,
            email = email_in,
            birthday = birth_in,
            avgMark = avg_in
    where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure delete_student(id_in int)
begin
    delete from student
        where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure find_student_by_name(name_in varchar(200) , OUT cnt int)
begin
    set cnt = (select count(id) from student where name like name_in);
end //
DELIMITER ;

DELIMITER //
create procedure search_student_by_name(name_in varchar(200))
begin
    select * from student
        where name like concat('%' , name_in , '%');
end //
DELIMITER ;

DELIMITER //
create procedure find_student_by_id(id_in int)
begin
    select * from student
        where id = id_in;
end //
DELIMITER ;