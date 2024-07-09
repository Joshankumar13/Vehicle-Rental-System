-- Create the vehicle_rental_system database
CREATE DATABASE vehicle_rental_system;

-- Use the vehicle_rental_system database
USE vehicle_rental_system;

-- Create the admin table
CREATE TABLE admins (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL
);

-- Create the vehicles table
CREATE TABLE vehicles (
    id INT PRIMARY KEY,
    brand VARCHAR(50),
    model VARCHAR(50),
    vehicle_condition VARCHAR(50),
    price_per_hour DOUBLE,
    available BOOLEAN
);

-- Create the customers table
CREATE TABLE customers (
    name VARCHAR(100),
    phone_number VARCHAR(15),
    license_number VARCHAR(20),
    PRIMARY KEY (name, phone_number, license_number)
);

-- Create the rentals table
CREATE TABLE rentals (
    rental_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    vehicle_id INT,
    booking_date DATE,
    FOREIGN KEY (customer_name) REFERENCES customers(name),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);

-- Show all tables in the database
SHOW TABLES;

-- Insert a sample admin user
INSERT INTO adminS (username, password) VALUES ('Joshan Roy', 'Jo@123');

-- Retrieve data from rentals
SELECT * FROM rentals;

-- Delete all data from vehicles
DELETE FROM vehicles;

-- Drop the customers table
DROP TABLE customers;

-- Truncate tables
TRUNCATE TABLE rentals;

