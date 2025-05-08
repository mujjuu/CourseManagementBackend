# Course Management System

## 📌 Overview
This is a **Spring Boot** application for managing courses, students, instructors, and enrollments. It follows a **layered architecture** with entity, repository, DAO, service, and controller layers. The project was created using **start.spring.io** i.e Spring Initializer and is designed to work with a **PostgreSQL** database.

## 🚀 Technologies & Dependencies
- **Spring Boot** (Search start.spring.io) --Spring Initializer
- **Spring Web** – REST APIs
- **Spring Data JPA** – Database interaction
- **Spring Boot DevTools** – Enhancing development workflow
- **PostgreSQL Driver** – Connecting to PostgreSQL

## Project Structure
courseEnrollmentSystem/ 
├── src/main/java/com/courseenrrolmentsystem/ 
│   
├── entity/                  # Contains all model classes 
│   
│   
├── Course.java 
│   
│   
├── Enrollment.java 
│   
│   
├── Student.java 
│   
│   
├── Instructor.java 
│   
├── repository/              # Interface extending JpaRepository with custom queries 
│   
├── dao/                     # Data access logic 
│   
├── service/                  # Business logic layer 
│   
├── response/                # ResponseEntity logic & ResponseStructure class 
│   
├── exception/               # Custom exceptions handling 
│   
├── controller/              # REST API controllers 
├── src/main/resources/ 
│   
├── application.properties   # Configuration properties for database 
│    
├── pom.xml                      # Project dependencies


## Database Relationships
- **Course** → Many-to-One with **Instructor**
- **Course** → One-to-Many with **Enrollment**
- **Enrollment** → Many-to-One with **Course** & **Student**
- **Instructor** → One-to-Many with **Course**
- **Student** → One-to-Many with **Enrollment**


## API EndPoints (Some Examples) -- Designed Total 25
| Method | Endpoint                      | Description |
|--------|--------------------------------|-------------|
| `POST` | `/course`                     | Create a new course |
| `GET`  | `/course`                     | Fetch all courses |
| `GET`  | `/student/{id}`               | Get student details by ID |
| `POST` | `/enrollment`                 | Enroll a student in a course |
| `GET`  | `/instructor/{id}`            | Fetch instructor details |

## 🛠️ How to Run
1. **Clone the Repository**  
   ```bash
   git clone https://github.com/yourusername/CourseManagementBackend.git
   cd CourseManagementBackend


2. **Set Up Environment Variables**
   In Eclipse -- Right Click On Project -- Run As -- Run Configurations --In the Run Configurations dialog: 
					1. Find your application's run configuration under Java Application
					2. Select your main class (typically CourseEnrollmentSystemApplication or similar)
	3. Go To Environment Tab On Top Right -- Click New -- Give Name And Value -- For Example --Name : DB_USER , Value : postgres and Click on Apply Then Run


3. API Testing
Use Postman to test API endpoints:- Send GET, POST, PUT, DELETE requests
- Validate JSON responses
- Check exception handling

4. Features Implemented 
CRUD operations for Course, Student, Enrollment, and Instructor
PostgreSQL database integration
Exception handling with custom error messages
Request validation & structured responses

5. Future Enhancements
- Implement JWT or OAuth authentication for secure access.
- Convert monolithic architecture to microservices.
- Add pagination for large datasets.


Author
Muzammil S - Backend Developer
Passionate about Spring Boot, PostgreSQL, and scalable API development.
