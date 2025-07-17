/*
In this file, we include statements to insert data into the empty tables that were previously created.
This approach is based on the examples provided by Vidhya et al. (2016), where all columns are populated using the INSERT INTO keyword.
The method involves inserting data values from left to right, following the order of the columns in each table definition.
*/
INSERT INTO library_system.Books values('9780441172719','Dune','Frank Herbert', 'science fiction','621');
INSERT INTO library_system.Books values('9780099134015','A Time To Kill','John Grisham', 'crime','432');

INSERT INTO library_system.Members values('0001','William Johnson','willyj@gmail.com','0734857163');
INSERT INTO library_system.Members values('0002','Sipho Khola','jadedjuice@gmail.com','0639751743');

INSERT INTO library_system.Loans values('00001','0002','9780441172719','2025-07-03','2025-07-17');
INSERT INTO library_system.Loans values('00002','0001','9780099134015','2025-04-01','2025-06-12');