CREATE TABLE IF NOT EXISTS product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(38,2)
    );

INSERT INTO product (name, description, price) VALUES ('Young', 'lower risik', 19.9);
INSERT INTO product (name, description, price) VALUES ('Middle', 'middle risik', 29.9);
INSERT INTO product (name, description, price) VALUES ('Luxus', 'high risik', 39.9);

CREATE TABLE IF NOT EXISTS customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birthday DATE,
    email VARCHAR(255),
    gender VARCHAR(255) NOT NULL,
    diabetics BOOLEAN,
    high_blood_pressure BOOLEAN,
    phone VARCHAR(255),
    product_id INT
    );

INSERT INTO customer (first_name, last_name, birthday, email, gender, diabetics, high_blood_pressure, phone, product_id) VALUES
                     ('Max', 'Mustermann', '1980-01-01', 'max.mustermann@versicherung.de', 'male', false, false, '+49152777444', 1);
INSERT INTO customer (first_name, last_name, birthday, email, gender, diabetics, high_blood_pressure, phone, product_id) VALUES
                     ('Peter', 'Pan', '1940-01-01', 'peter.pan@versicherung.de', 'male', false, false, '+49153123456', 3);

CREATE TABLE IF NOT EXISTS "order" (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_date TIMESTAMP,
    start_date DATE,
    end_date DATE,
    paid BOOLEAN,
    product_id INT,
    customer_id INT
    );

INSERT INTO "order" (order_date, start_date, end_date, paid, product_id, customer_id) VALUES
    ('2020-05-01 08:00:00', '2020-06-01', '2020-06-05', false, 1, 1);
INSERT INTO "order" (order_date, start_date, end_date, paid, product_id, customer_id) VALUES
    ('2019-03-01 22:00:00', '2019-09-01', '2019-12-01', true, 3, 2);