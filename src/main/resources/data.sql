INSERT INTO person (name, birth_date)
VALUES
    ('Selena', '2020-06-01'),
    ('Belchior', '2020-06-01');

INSERT INTO address (street, zip_code, number, city)
VALUES
    ('Rua A', '60000-000', '123', 'Fortaleza'),
    ('Rua B', '60000-000', '456', 'Fortaleza');

INSERT INTO person_address (person_id, address_id, is_primary)
VALUES
    (1, 1, true),
    (2, 2, true);
