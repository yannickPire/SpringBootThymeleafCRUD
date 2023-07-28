insert into adres (street, number, zip_code, city, country, contact_id)
values ('Dorpstraat', '1', '3000', 'Leuven', 'Belgium',
        (select id from contact where firstname = 'John' and lastname = 'Doe'));

insert into adres (street, number, zip_code, city, country, contact_id)
values ('Grote Markt', '13', '3000', 'Leuven', 'Belgium',
        (select id from contact where firstname = 'John' and lastname = 'Doe'));