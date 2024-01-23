DROP TABLE IF EXISTS customer;

CREATE SEQUENCE customer_id_seq;

CREATE TABLE customer
(
    id BIGINT PRIMARY KEY DEFAULT nextval('customer_id_seq'),
    name VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    age INT NOT NULL CHECK (age > 0)
);


ALTER SEQUENCE  customer_id_seq
    OWNED BY customer.id;
