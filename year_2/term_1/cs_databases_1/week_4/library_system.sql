/* 
In this file, we create the database schema and tables. I use the examples presented by Vidhya et al. (2016) as a reference for this implementation.
*/

# Creates the database schema
CREATE DATABASE library_system;

# Switches to the library_system database so that the following statements are executed within it
USE library_system;

/*
This is the first table we create: Books. The ISBN serves as the primary key.
We use BIGINT instead of a regular INT because an ISBN can contain up to 13 digits, which exceeds the limit of an INT.
The Title, Author, and Genre fields use VARCHAR with a character limit of 255, which is the maximum, as these values may vary in length.
The Quantity field is stored as an INT to represent the number of copies available in stock.
*/
CREATE TABLE Books (
    ISBN BIGINT NOT NULL PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL,
    Genre VARCHAR(255) NOT NULL,
    Quantity INT NOT NULL
);

/*
This is the second table, and it keeps track of member information. The MemberID is the primary key and is stored as an INT.
The Name and Email fields are defined as VARCHAR(255) to account for variability in character length.
Phone numbers can be up to 15 digits long. Since no arithmetic operations are performed on them, VARCHAR(15) is an appropriate choice to save space and limit input length.
*/

CREATE TABLE Members (
    MemberID INT NOT NULL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Phone VARCHAR(15)
);

/*
This is the Loans table, which stores information about book loans. This table contains more elements, including two foreign keys, which are used to track loan records accurately.
Firstly, we define LoanID as the primary key.
For the foreign keys, I followed the approach outlined by W3Schools (2019), where a column is first created, and then a foreign key constraint is added to it.
We do this for both the MemberID and ISBN fields.
The LoanDate and ReturnDate fields use the DATE data type to track the loan period.
*/
CREATE TABLE Loans (
    LoanID INT NOT NULL PRIMARY KEY,
    MemberID INT NOT NULL,
    FOREIGN KEY (MemberID)
        REFERENCES Members (MemberID),
    ISBN BIGINT NOT NULL,
    FOREIGN KEY (ISBN)
        REFERENCES Books (ISBN),
    LoanDate DATE NOT NULL,
    ReturnDate DATE NOT NULL
);