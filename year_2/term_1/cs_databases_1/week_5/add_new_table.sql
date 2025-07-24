/*
In this file we use the USE keyword to select which database schema we are working in.
Then we create the Authors table with the AuthorID attribute, which has the INT data type and is the primary key.
The Name and Nationality have the VARCHAR data types as they are of varying lengths, and the BirthYear has a SMALLINT
data type as it would normally comprise four digits.
*/

USE library_system;

CREATE TABLE Authors (
    AuthorID INT NOT NULL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Nationality VARCHAR(255) NOT NULL,
    BirthYear SMALLINT NOT NULL
);