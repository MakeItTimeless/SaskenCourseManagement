# E-Learning Application

## Overview
This is an e-learning application designed to facilitate online learning. The application allows users to enroll in courses, manage their profiles, and track their progress. It uses MySQL as the database to store user, course, and enrollment information.

## Project Structure
The project is organized as follows:

```
e-learning-app
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── elearning
│   │   │   │       ├── ui
│   │   │   │       │   └── MainUI.java
│   │   │   │       ├── dao
│   │   │   │       │   ├── CourseDAO.java
│   │   │   │       │   ├── UserDAO.java
│   │   │   │       │   └── EnrollmentDAO.java
│   │   │   │       ├── models
│   │   │   │       │   ├── Course.java
│   │   │   │       │   ├── User.java
│   │   │   │       │   └── Enrollment.java
│   │   │   │       └── utils
│   │   │   │           └── DBConnection.java
│   │   └── resources
│   │       └── application.properties
├── pom.xml
└── README.md
```

## Setup Instructions
1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd e-learning-app
   ```

2. **Configure the database**:
   - Create a MySQL database for the application.
   - Update the `src/main/resources/application.properties` file with your database connection details.

3. **Build the project**:
   - Ensure you have Maven installed.
   - Run the following command to build the project:
   ```
   mvn clean install
   ```

4. **Run the application**:
   - Execute the main class `MainUI.java` to start the application.

## Usage
- Users can register and log in to the application.
- Once logged in, users can view available courses, enroll in courses, and view their enrolled courses.

## Dependencies
This project uses Maven for dependency management. The required dependencies are specified in the `pom.xml` file.

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.