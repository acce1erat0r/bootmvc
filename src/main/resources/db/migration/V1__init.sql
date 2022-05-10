DROP TABLE IF EXISTS products;
CREATE TABLE products
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    price       BIGINT
);

INSERT INTO products (title, description, price)
VALUES ('MacBook', 'Ultra low and Great Power', 3000 ),
        ('Iphone', 'The most expensive phone by credit', 1000 ),
        ('iMac', 'More size - more cost', 10000 ),
        ('Ipad', 'More size - more cost', 2000 );



DROP TABLE IF EXISTS items;
CREATE TABLE items
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(40) UNIQUE NOT NULL

);

INSERT INTO items (title)
VALUES
('stone'), ('dick'), ('knife'), ('spoon');