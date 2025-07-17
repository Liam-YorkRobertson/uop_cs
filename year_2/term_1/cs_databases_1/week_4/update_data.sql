/*
In this file, we aim to change the quantity value of a specific book.
Following the example provided by Vidhya et al. (2016), we use the UPDATE keyword to alter column values in a table.
In this case, we are updating the quantity to 100, based on the condition that the ISBN matches the one provided.
*/
UPDATE library_system.Books 
SET 
    Quantity = 100
WHERE
    ISBN = 9780441172719;