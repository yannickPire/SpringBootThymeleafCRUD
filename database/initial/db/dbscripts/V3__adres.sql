create table adres (
   id               bigint auto_increment primary key,
   street           varchar(255) null,
   number           varchar(255) null,
   zip_code         varchar(255) null,
   city             varchar(255) null,
   country          varchar(255) null,
   contact_id       bigint,
   constraint fk01_contact_adres foreign key (contact_id) references contact(id)
);

insert into adres (street, number, zip_code, city, country, contact_id) values ('Dorpstraat', '1', '3000', 'Leuven', 'Belgium', (select id from contact where firstname = 'Jane' and lastname = 'Doe'));