create table contact
(
    id           bigint auto_increment primary key,
    emailaddress varchar(255) null,
    firstname    varchar(255) null,
    lastname     varchar(255) null,
    phonenumber  varchar(255) null
);