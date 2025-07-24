/*
We are using the SELECT keyword to display all information about books written by the specified author.
Based on the examples by Vidhya et al. (2016).
*/

SELECT 
    *
FROM
    library_system.Books
WHERE
    author = 'Frank Herbert';