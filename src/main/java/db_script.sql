CREATE DATABASE megacitycab;
USE megacitycab;

CREATE TABLE users (
                       userID INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(50) NOT NULL,
                       role ENUM('Customer', 'Admin', 'Manager') NOT NULL
);

CREATE TABLE customers (
                           customerID INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           address VARCHAR(200) NOT NULL,
                           NIC VARCHAR(12) NOT NULL UNIQUE,
                           phoneNumber VARCHAR(15) NOT NULL,
                           userID INT,
                           FOREIGN KEY (userID) REFERENCES users(userID)
);

CREATE TABLE drivers (
                         driverID INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         licenseNumber VARCHAR(20) NOT NULL UNIQUE,
                         contactNumber VARCHAR(15) NOT NULL
);

CREATE TABLE cars (
                      carID INT AUTO_INCREMENT PRIMARY KEY,
                      model VARCHAR(50) NOT NULL,
                      licensePlate VARCHAR(20) NOT NULL UNIQUE,
                      availability ENUM('Available', 'Unavailable') DEFAULT 'Available'
);

CREATE TABLE bookings (
                          bookingID INT AUTO_INCREMENT PRIMARY KEY,
                          customerID INT,
                          pickupLocation VARCHAR(200) NOT NULL,
                          destination VARCHAR(200) NOT NULL,
                          bookingDate DATE NOT NULL,
                          fare DECIMAL(10, 2) NOT NULL,
                          FOREIGN KEY (customerID) REFERENCES customers(customerID)
);

CREATE TABLE bills (
                       billID INT AUTO_INCREMENT PRIMARY KEY,
                       bookingID INT,
                       totalAmount DECIMAL(10, 2) NOT NULL,
                       tax DECIMAL(10, 2) NOT NULL,
                       discount DECIMAL(10, 2) NOT NULL,
                       FOREIGN KEY (bookingID) REFERENCES bookings(bookingID)
);