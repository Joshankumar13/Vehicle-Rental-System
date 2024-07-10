# Vehicle Rental System

## Description
The Vehicle Rental System is a comprehensive application designed to manage the rental process of vehicles. It provides functionalities for both admins and customers, enabling efficient management of vehicle rentals. The system is developed using Java and SQL, ensuring robust performance and reliable data management.

## Features
- **Admin Functionalities:**
  - Add, remove, view, and update vehicle details
  - View and manage bookings, including removing customer bookings
  - View all vehicles and booked vehicles

- **Customer Functionalities:**
  - View available vehicles
  - Book vehicles and receive confirmation messages with instructions

## Installation
1. **Clone the repository:**
    ```bash
    git clone https://github.com/joshan-18/Vehicle-Rental-System.git
    ```
2. **Navigate to the project directory:**
    ```bash
    cd Vehicle-Rental-System
    ```
3. **Set up the database:**
   - Import the SQL script located in the `database` directory to your MySQL server.

4. **Compile the project:**
    - Use an IDE like IntelliJ IDEA or Eclipse to import the project and compile the Java files.
    - Ensure that the MySQL JDBC driver is added to the project dependencies.

## Usage
1. **Run the application:**
   - Execute the `MainApp` class to start the application.

2. **Admin Login:**
   - Use the admin credentials to log in and access admin functionalities.

3. **Customer Menu:**
   - Access the customer menu to view and book available vehicles.

## Project Structure
- **Admin:**
  - Contains classes and methods for admin functionalities.
- **Customer:**
  - Manages customer-related operations.
- **Vehicle:**
  - Handles vehicle information and operations.
- **DAO (Data Access Objects):**
  - Interfaces and implementations for database interactions.
- **Menus:**
  - Separate menus for admin and customer interactions.
- **MainApp:**
  - Entry point of the application.
- **Database:**
  - Contains SQL scripts for database setup.

## Technologies Used
- **Programming Languages:**
  - Core Java, J2EE
- **Database:**
  - MySQL
- **Tools:**
  - IntelliJ IDEA or Eclipse for development
  - MySQL Workbench for database management

## Screenshots
For demo screenshots of the application, please visit the [screenshots folder](https://github.com/joshan-18/Vehicle-Rental-System/tree/main/ProjectScreenshots).

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
- **Email:** joshanroy13@gmail.com
