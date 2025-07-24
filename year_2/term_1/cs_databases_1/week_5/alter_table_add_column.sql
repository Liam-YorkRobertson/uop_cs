/*
Using the article by Peterson (2022), I was able to construct a command to add a new column to the Members table.
We use the ALTER TABLE command to identify which table we are going to modify, and the ADD COLUMN specifies that we want to add
a column to the table. It is then followed by the new column name, data type, and constraints.
*/

ALTER TABLE library_system.Members ADD COLUMN MembershipType VARCHAR(255) NOT NULL;