-- ==============================================================
-- Setup Instructions for `schema.sql`
-- ==============================================================
-- 1. Download or clone this repository.
-- 2. Locate and open the `schema.sql` file.
-- 3. Run this script in your MySQL environment:
--    - Using MySQL Workbench: Open the file and run the script.
--    - Using Command-Line: 
--      1. Open the terminal/command prompt.
--      2. Navigate to the directory where the `schema.sql` file is located.
--      3. Run the following command:
--         mysql -u your_username -p < schema.sql
--    - This will create the `acadisia` database and the required tables.
-- 4. Update the database connection settings in your Java application.
-- ==============================================================
-- Create the database if not exists
CREATE DATABASE IF NOT EXISTS acadisia;
USE acadisia;

-- Userinfo table: stores admins and students
CREATE TABLE userinfo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(200) UNIQUE NOT NULL,   | 
    password VARCHAR(30) NOT NULL,
    role VARCHAR(20) DEFAULT 'student'
);

-- Questionbank table: stores all questions
CREATE TABLE questionbank (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_text TEXT NOT NULL,
    subject VARCHAR(50) NOT NULL,
    answer TEXT NOT NULL
);

-- Quiz table: stores quiz metadata
CREATE TABLE quiz (
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(50) NOT NULL,
    question_text TEXT NOT NULL,
    option_a VARCHAR(200) NOT NULL,
    option_b VARCHAR(200) NOT NULL,
    option_c VARCHAR(200) NOT NULL,
    option_d VARCHAR(200) NOT NULL,
    correct_answer VARCHAR(200) NOT NULL 
);

-- Results table: stores scores by users
CREATE TABLE IF NOT EXISTS result (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    question_id INT NOT NULL,
    question TEXT NOT NULL,
    option_a VARCHAR(200) NOT NULL,
    option_b VARCHAR(200) NOT NULL,
    option_c VARCHAR(200) NOT NULL,
    option_d VARCHAR(200) NOT NULL,
    selected_answer VARCHAR(200) NOT NULL,
    correct_answer VARCHAR(200) NOT NULL,
    subject VARCHAR(50) NOT NULL,
    FOREIGN KEY (question_id) REFERENCES questionbank(question_id)
);
