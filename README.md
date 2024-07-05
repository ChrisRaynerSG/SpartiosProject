# Project Requirements
- Reading and Parsing the CSV File
File I/O: Use Python to read the CSV file.
Data Parsing: Parse the data into a suitable data structure (e.g., a list of dictionaries).
- Data Cleaning
The data in the CSV file may be corrupted. Ensure the data meets the following criteria before storing it in the database:

- Emp ID: 6 digits
- Prefix
- First Name
- Middle Initial
- Last Name
- Gender: Stored as 'M' or 'F'
- E Mail: In standard email format
- Date of Birth: MM/DD/YYYY
- Date of Joining: MM/DD/YYYY
- Salary
- Logging: Inform the user of how many employee records are corrupted using a suitable logging mechanism.

- Storing Data in MySQL Database
Database Creation: Create a new MySQL database and a table to store the employee data.
Data Types: Carefully select appropriate data types for each column in the table.
- DAO Class for Database Interaction
Provide a DAO (Data Access Object) class to interact with the database.
Implement CRUD (Create, Read, Update, Delete) operations for the employees.
