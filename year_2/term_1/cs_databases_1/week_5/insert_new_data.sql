/*
I am once again using the technique described by Vidhya et al. (2016) to insert sample data
into the tables. There are 10 books, 5 authors, 20 members, and 10 loans added using this file.
*/

INSERT INTO library_system.Books VALUES ('9780425037910', 'The Dosadi Experiment', 'Frank Herbert', 'science fiction', '296');
INSERT INTO library_system.Books VALUES ('9780747532743', 'Harry Potter and the Philosopher\'s Stone', 'Joanne Rowling', 'fantasy', '223');
INSERT INTO library_system.Books VALUES ('9780553103540', 'A Game of Thrones', 'George Raymond Richard Martin', 'fantasy', '694');
INSERT INTO library_system.Books VALUES ('9780450411434', 'It', 'Stephen Edwin King', 'horror', '1138');
INSERT INTO library_system.Books VALUES ('9780099448792', 'Norwegian Wood', 'Haruki Murakami', 'romance', '296');
INSERT INTO library_system.Books VALUES ('9780345538376', 'A Clash of Kings', 'George Raymond Richard Martin', 'fantasy', '768');
INSERT INTO library_system.Books VALUES ('9780670813025', 'Misery', 'Stephen Edwin King', 'thriller', '320');
INSERT INTO library_system.Books VALUES ('9780747538493', 'Harry Potter and the Chamber of Secrets', 'Joanne Rowling', 'fantasy', '251');
INSERT INTO library_system.Books VALUES ('9780099448822', 'Kafka on the Shore', 'Haruki Murakami', 'magical realism', '505');
INSERT INTO library_system.Books VALUES ('9780340960196', 'Under the Dome', 'Stephen Edwin King', 'science fiction', '1074');

INSERT INTO library_system.Authors VALUES ('0001', 'Frank Herbert', 'United States', '1920');
INSERT INTO library_system.Authors VALUES ('0002', 'J.K. Rowling', 'United Kingdom', '1965');
INSERT INTO library_system.Authors VALUES ('0003', 'George R. R. Martin', 'United States', '1948');
INSERT INTO library_system.Authors VALUES ('0004', 'Stephen King', 'United States', '1947');
INSERT INTO library_system.Authors VALUES ('0005', 'Haruki Murakami', 'Japan', '1949');

INSERT INTO library_system.Members VALUES ('0003', 'Emily Smith', 'emilysmith@mail.com', '0712345678');
INSERT INTO library_system.Members VALUES ('0004', 'Sipho Dlamini', 'sipho.d@protonmail.com', '0734567890');
INSERT INTO library_system.Members VALUES ('0005', 'Aisha Khan', 'aisha.khan@outlook.com', '0745678901');
INSERT INTO library_system.Members VALUES ('0006', 'Liam Patel', 'liam.patel@webmail.co.za', '0767890123');
INSERT INTO library_system.Members VALUES ('0007', 'Chloe Williams', 'cwilliams@gmail.com', '0612345678');
INSERT INTO library_system.Members VALUES ('0008', 'Karabo Ndlovu', 'karabo.ndlovu@studentmail.ac.za', '0834567890');
INSERT INTO library_system.Members VALUES ('0009', 'Olivia Brown', 'olivia_b123@protonmail.com', '0723456789');
INSERT INTO library_system.Members VALUES ('0010', 'Mohammed Abrahams', 'm.abrahams@outlook.com', '0743210987');
INSERT INTO library_system.Members VALUES ('0011', 'Zanele Khumalo', 'zanele.k@icloud.com', '0623456789');
INSERT INTO library_system.Members VALUES ('0012', 'Ethan Johnson', 'ethanj99@yahoo.com', '0786543210');
INSERT INTO library_system.Members VALUES ('0013', 'Noluthando Mthembu', 'noluthando.m@gmail.com', '0711122334');
INSERT INTO library_system.Members VALUES ('0014', 'Lucas White', 'lucas.white@live.com', '0609876543');
INSERT INTO library_system.Members VALUES ('0015', 'Amogelang Tshabalala', 'amo.tshabalala@proton.me', '0733344556');
INSERT INTO library_system.Members VALUES ('0016', 'Sophia Adams', 's.adams@mailbox.org', '0821122334');
INSERT INTO library_system.Members VALUES ('0017', 'Tebogo Molefe', 'tmolefe@zoho.com', '0756677889');
INSERT INTO library_system.Members VALUES ('0018', 'Grace Taylor', 'grace.t@outlook.com', '0798765432');
INSERT INTO library_system.Members VALUES ('0019', 'Naledi Phiri', 'naledi.phiri@tut4life.ac.za', '0837788990');
INSERT INTO library_system.Members VALUES ('0020', 'James Anderson', 'anderson.james@fastmail.com', '0765544332');
INSERT INTO library_system.Members VALUES ('0021', 'Ayanda Nkosi', 'ayanda.nkosi@outlook.com', '0841234567');
INSERT INTO library_system.Members VALUES ('0022', 'Nandi Maseko', 'nandi.maseko@gmail.com', '0793456721');

INSERT INTO library_system.Loans VALUES ('00003', '0008', '9780747532743', '2025-06-10', '2025-06-24');
INSERT INTO library_system.Loans VALUES ('00004', '0003', '9780553103540', '2025-07-01', '2025-07-15');
INSERT INTO library_system.Loans VALUES ('00005', '0011', '9780450411434', '2025-06-20', '2025-07-04');
INSERT INTO library_system.Loans VALUES ('00006', '0005', '9780099448792', '2025-07-05', '2025-07-19');
INSERT INTO library_system.Loans VALUES ('00007', '0010', '9780345538376', '2025-06-15', '2025-06-29');
INSERT INTO library_system.Loans VALUES ('00008', '0007', '9780670813025', '2025-07-08', '2025-07-22');
INSERT INTO library_system.Loans VALUES ('00009', '0004', '9780747538493', '2025-06-25', '2025-07-09');
INSERT INTO library_system.Loans VALUES ('00010', '0012', '9780099448822', '2025-07-10', '2025-07-24');
INSERT INTO library_system.Loans VALUES ('00011', '0009', '9780340960196', '2025-06-12', '2025-06-26');
INSERT INTO library_system.Loans VALUES ('00012', '0006', '9780747532743', '2025-07-12', '2025-07-26');