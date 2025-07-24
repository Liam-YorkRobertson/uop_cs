/*
As we are retrieving data from two tables based on a common attribute, we are using the JOIN keyword.
The article by GeeksforGeeks (2025) outlined how to use the JOIN statement, and in the command below,
we use SELECT Name as we specifically want that field from the Members table, joined with the Loans table,
where the ISBN matches the specified book we want to identify who is renting.
*/

SELECT 
    Name
FROM
    library_system.Members
        JOIN
    library_system.Loans ON Members.MemberID = Loans.MemberID
WHERE
    Loans.ISBN = '9780747532743';