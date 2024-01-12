# angular-spring
Spring Angular CRUD Application
# angular-spring


This is a Spring Angular Project used to enter, delete and update data of students in a web application.

This application contains two components,
1.	Spring Boot: This project is used to develop CRUD RESTFul APIs for a simple Student Management System using Spring Boot, JPA, and MySQL as a Database. is the back-end application
2.	Angular: This project is used to develop a single-page application using Angular 8 as a front-end technology.
## Tools  to be used
- STS / any java IDE - To develop the Spring project
- MySQL / h2 for the database
- Visual Studio Code- To develop an Angular project
- Apache Tomcat Server
- Maven
- Java 
- Hibernate

## _Dependencies_
- Spring Boot Dev Tools
- Spring Web
- Lombok
- Spring Data JPA
- MYSQL Driver/H2(H2 is for testing)
- Mapstruct
- JUnit
## 





## _Features Implemented_

- Create a student
- Update a student
- Delete Student
- View Students


## Spring Boot CRUD Rest APIs Development
Below components, configuration and packages are needed for Spring Boot Application
1.	Configuring Database: Configure application. properties to connect to your MySQL Database.
2.	Open STS and create a “Spring Starter Project“
3.	Select all dependencies.
4.	Create a package “model” in src/main/java folder.
5.	Create JPA Entity- Student.java in the “model” package with the following fields
-    id as primary key
-    name
-    email
-    branch
6.	Create a Service interface- “StudentService” in the service package.
7.	Create a Service class “StudentServiceImpl”  in the service. impl package.
8.	 Create a Spring Data Repository- StudentDAO.java to access Student’s data from the database.
9.	Create Spring Rest Controller-StudentController.java for creating, retrieving,updating, and deleting a student.
10.	Update the “application.properties “ file of src/main/resources folder.
11.	Create a package“config” in src/main/java folder and provide java classes to configure Cross-Origin Resource Sharing (CORS) and to enable logging for API calls from Angular.

## Run backend
To start backend, Run _SpringStarterProj_ as Spring Boot App

## Angular 8 Client App Development

1.	Create a new Angular Project “angular-spring”.
2.	Install Bootstrap CSS framework into the project.
3.	Install Angular -Data Table into the project.
4.	Open “angular-spring” folder in Visual Studio Code.
5.	Create the following components 
    >          >ng g c AddStudent 
    >          >ng g c StudentList
6.	Create the following Service
	>          >ng g s Student
7.	Update “app-routing.module.ts” of src/app folder.
8.	Edit “app.component.html”.
9.	Create a class “Student” 
>              >ng g class Student.
10.	Edit Student.ts.
11.	Edit student.service.ts.
12.	Edit “add-student.component.ts”.
13.	Edit “add_student.component.html”.
14.	Edit “student-list.component.ts”.
15.	Edit “student-list.component.html”.
##	Run Angular Project 
>               >ng serve.



![Thank
you\!](https://media.giphy.com/media/3o6ozuHcxTtVWJJn32/giphy.gif)
