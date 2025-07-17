/*
In this file, we want to delete a specific member’s records from the Members table, using the technique provided by Vidhya et al. (2016).
When I first attempted to delete the entry from the Members table, I received an error indicating that there was a foreign key constraint.
Therefore, to delete a primary key, it must not be referenced as a foreign key in another table.
As a result, I first deleted the rows in the Loans table where the MemberID is used as a foreign key.
This then allowed me to delete the corresponding primary key row from the Members table.
*/
DELETE FROM library_system.Loans 
WHERE
    MemberID = 0001;
DELETE FROM library_system.Members 
WHERE
    MemberID = 0001;