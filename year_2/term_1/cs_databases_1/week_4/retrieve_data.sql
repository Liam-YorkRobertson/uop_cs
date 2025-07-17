/*
In this file, we aim to display data about books loaned out by a specific member using the SELECT keyword (Vidhya et al., 2016).
However, the scope of the requirements goes beyond the examples provided in the textbook, so I referred to information from GeeksforGeeks (2025) 
regarding JOIN operations in order to construct the statement below.
We select all rows from the Books and Loans tables, which is made possible through the use of the JOIN keyword. 
This is done by matching rows where the ISBN values are the same, with an additional condition that the MemberID corresponds to the one provided.
*/
SELECT 
    *
FROM
    library_system.Books
        JOIN
    library_system.Loans ON Books.ISBN = Loans.ISBN
WHERE
    Loans.MemberID = '0001';
