# Online Examination Portal - Acadisia

This is a full-stack web application designed for conducting online exams. It allows **students** to take quizzes, view their results, and for **admins** to manage users, quizzes, and question banks.

## Features

### Admin Features:
- **User Management**: Add, delete, modify, and search users.
- **Question Bank Management**: Add, edit, and delete questions.
- **Quiz Management**: Create and manage quizzes.
- **Result Analysis**: View individual student results.

### Student Features:
- **Attempt Quizzes**: Take quizzes with multiple-choice questions.
- **View Results**: See scores and view attempted questions with correct answers.

## Technologies Used

- **Backend**: Java (Core Java, Servlets, JSP)
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Server**: Apache Tomcat
- **IDE**: Eclipse IDE

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java (JDK 8 or above)
- MySQL database
- Apache Tomcat (for running the web application)
- Eclipse IDE or any Java IDE for development

### Setup

1. **Clone the repository**:

    ```bash
    git clone https://github.com/yourusername/online-examination-portal.git
    ```

2. **Set up the database**:
    - Import the database schema using the `schema.sql` file. You can find it under the `database/` folder of the project.
    
    ```bash
    mysql -u your_username -p < database/schema.sql
    ```

3. **Configure the database connection**:
    - Open the `application.properties` file (or wherever your DB configuration is set) and update the MySQL database connection details:
    
    ```properties
    jdbc.url=jdbc:mysql://localhost:3306/acadisia
    jdbc.username=your_username
    jdbc.password=your_password
    ```

4. **Deploy the application**:
    - Import the project into **Eclipse IDE** or any Java IDE.
    - Set up **Apache Tomcat** in your IDE and deploy the project.
    - Access the application by navigating to `http://localhost:8080/online-examination-portal`.


## Database Schema

The project uses MySQL for data storage. Here is the schema setup used by the application:

- **`userinfo`**: Stores user details (students and admins) including name, email, password, and role (default: student).
- **`questionbank`**: Contains all quiz questions, associated subjects, and correct answers.
- **`quiz`**: Stores quiz questions, options, and correct answers.
- **`result`**: Records each student's quiz attempt, selected answers, and the result.

You can find the schema in the `database/schema.sql` file.

## Contact

For any questions or suggestions, feel free to reach out:

- **Email**: radspatidar@gmail.com
- **GitHub**: [radspatidar](https://github.com/radspatidar)
- **LinkedIn**: [radhika-patidar-140808296](https://www.linkedin.com/in/radhika-patidar-140808296)

I’ll be happy to help!
