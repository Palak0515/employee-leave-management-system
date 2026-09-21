# employee-leave-management-system

# Description
Employee Leave Management System is a console-based application for managing employee leave requests. Employees can submit leave applications and view their leave history, while managers can review, approve, reject, and add remarks to requests. The system maintains organized leave records for efficient leave management.

# Features
1. Employee <br>
- employee <br>
- Find employee by ID <br> 
- Apply for leave <br> 
- View leave history <br>
  
2. Manager <br>
- Add manager <br>
- View pending leave requests <br>
- Find leave by ID <br> 
- Update leave status <br> 
- Add or update leave remarks <br>
  
# Technologies Used
Java <br>
JDBC <br>
MySQL <br> 
SQL <br> 

# Project Structure 
src/ <br>
└── leaveManagement/ <br>
    ├── Main.java <br>
    ├── Manager.java <br> 
    ├── ManagerDAO.java <br>
    ├── Employee.java <br>
    ├── EmployeeDAO.java <br> 
    ├── LeaveRequest.java <br>
    ├── LeaveDAO.java <br>
    └── databaseConnection.java <br>
    
# Database
- The project uses a MySQL database named leave_employee_management. <br>
- The database contains three main tables: manager, employee, leave_request. <br>
- The relationships are maintained using foreign keys: <br>

Manager <br>
   │ <br>
   │ 1 : N <br>
   ▼ <br>
Employee <br>
   │ <br>
   │ 1 : N <br>
   ▼ <br>
Leave Request <br>

Manager ID, Employee ID, and Leave ID are automatically generated using auto-increment primary keys.

# Leave Status
- Leave requests support the following statuses: pending, approved, rejected
- New leave requests are created with a default status of pending.

# Architecture

The application follows a simple DAO-based architecture: <br>
Main.java<br>
    |<br>
DAO Layer<br>
    |<br>
   JDBC<br>
    |<br>
MySQL Database<br>

Model classes represent the application data, while DAO classes handle database operations.

# Setup and Run
1. Install Java JDK and MySQL. <br>
2. Create the leave_employee_management database. <br>
3. Execute the SQL script provided in the project. <br>
4. Configure the MySQL username and password in databaseConnection.java. <br>
5. Add the MySQL Connector/J dependency to the project. <br>
6. Run Main.java.  <br>

# Concepts Demonstrated
- Object-Oriented Programming <br>
- JDBC database connectivity <br>
- SQL and relational database design <br>
- CRUD operations<br>
- PreparedStatement<br>
- Primary and foreign keys<br>
- Exception handling<br>
- DAO pattern<br>
- Console-based application development<br>

# Future Enhancements
1. User authentication and role-based access<br>
2. Leave balance management<br>
3. Leave notifications<br>
4. Improved input validation<br>
5. Web or GUI-based interface<br>
6. Reporting and analytics<br>
