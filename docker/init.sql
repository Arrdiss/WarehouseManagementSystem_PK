-- Użyj lub stwórz bazę danych
CREATE DATABASE IF NOT EXISTS WarehouseManagement;
USE WarehouseManagement;

-- Tabela z rolami użytkowników
CREATE TABLE Roles (
    RoleID INT PRIMARY KEY AUTO_INCREMENT,
    RoleName VARCHAR(50) NOT NULL
);

-- Tabela z użytkownikami
CREATE TABLE Users (
    Email VARCHAR(255) PRIMARY KEY,
    FirstName VARCHAR(100),
    LastName VARCHAR(100),
    PasswordHash VARCHAR(255) NOT NULL,
    RoleID INT,
    FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
);

-- Tabela z produktami w magazynie
CREATE TABLE Products (
    ProductCode VARCHAR(50) PRIMARY KEY,
    Description VARCHAR(255),
    QuantityInStock INT DEFAULT 0,
    Archived BOOLEAN DEFAULT FALSE
);

-- Tabela zamówień i zapotrzebowania
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    ProductCode VARCHAR(50),
    Quantity INT NOT NULL,
    OrderDate DATE DEFAULT CURRENT_DATE,
    CreatedBy VARCHAR(255),
    ApprovedBy VARCHAR(255),
    Status ENUM('In Progress', 'Completed') DEFAULT 'In Progress',
    FOREIGN KEY (ProductCode) REFERENCES Products(ProductCode),
    FOREIGN KEY (CreatedBy) REFERENCES Users(Email),
    FOREIGN KEY (ApprovedBy) REFERENCES Users(Email)
);

-- Przykładowe dane do tabeli Roles
INSERT INTO Roles (RoleName) VALUES ('Administrator'), ('User');


-- Przykładowe dane do tabeli Products
INSERT INTO Products (ProductCode, Description, QuantityInStock, Archived) VALUES
('PROD001', 'Product 1 Description', 100, FALSE),
('PROD002', 'Product 2 Description', 50, FALSE),
('PROD003', 'Product 3 Description', 0, TRUE);

-- Przykładowe dane do tabeli Orders
INSERT INTO Orders (ProductCode, Quantity, OrderDate, CreatedBy, ApprovedBy, Status) VALUES
('PROD001', 10, '2024-01-10', 'admin@example.com', 'admin@example.com', 'Completed'),
('PROD002', 5, '2024-02-15', 'user@example.com', NULL, 'In Progress');

