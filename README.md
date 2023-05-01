# Movie Quotes API

## Spring Boot Mini-Project
* <a href="#project-description">Project Description</a>
* <a href="#technologies-used">Technologies Used</a>
* <a href="#project-planning-process">Project Planning Process</a>
* <a href="#learnings-takeaways">Learnings/ Takeaways</a>
* <a href="#installation-instructions">Installation Instructions</a>
* <a href="#credits">Credits</a>

---
## Project Description

This project aims to build a monolithic 
backend using Spring Boot and its modules in order to create a web API. 
By using movies and their popular quotes, you can have fun querying and creating all the movie quotes your heart desires.

### User Stories
- [x] As a User, I want to be able to create an account, so I can have a user profile.
- [x] As a User, I want to have a list of many movies in my account.
- [x] As a User, I want to add many Movies so that I can have many notable quotes.
- [x] As a User, I want certain information accessible only to me.

### Technical Requirements
* PostgreSQL database should consist of a minimum of three models
* Environment settings set up using Spring Profiles
* Combination of Spring Security and JWT tokens is required in order to authenticate and personalize API endpoints while maintaining the overall security of the application.
* API endpoints to perform complete CRUD operations
* Exception Handling & error message sending.
* Adhere to KISS and DRY principals
---

## Technologies Used
* **Java**
* **IntelliJ IDEA** (with Java 17)
* **Spring Boot** - version 2.7.8
* **PostgreSQL database** - pgAdmin 4
* **Postman** - testing DB requests
* **Spring Initializr** 
* **Maven Repository** - https://mvnrepository.com/
* **ERD Tool** - https://www.lucidchart.com/
* **Markdown Table Generator** - https://www.tablesgenerator.com/markdown_tables

---
## Project Planning Process

I started out this project by rereading documentation on Spring and the MVC design.

I highlight 3 key areas that I focused on when planning out the project:
1. Started with my ERD design to help me visualize my DB and the relationships I would need to make between models/tables
2. Kanban board to plan out all steps and project requirements need to successfully complete the project.
3. Mapped out all REST API Endpoints to help understand functionality

*I also wrote out all User Stories for reference points throughout the project*

### ERD Diagram
![](/images/DB_ER_diagram.png)

### Kanban/ Agile Approach
![](/images/agile_project_plan.png)

### Functionality/ REST API Endpoints

#### Movie Controller
| HTTP Methods 	| Full URL                                    	|                 URL                	|        Functionally        	|
|--------------	|---------------------------------------------	|:----------------------------------:	|:--------------------------:	|
| GET          	| http://localhost:9893/api/movies/           	| /movies/                           	| Get All movies             	|
| GET          	| http://localhost:9893/api/movies/1          	| /movies/{movieId}                  	| Get Movie By Id            	|
| POST         	| http://localhost:9893/api/movies/           	| /movies/                           	| Create Movie               	|
| PUT          	| http://localhost:9893/api/movies/1          	| /movies/{movieId}                  	| Update Movie By Id         	|
| DELETE       	| http://localhost:9893/api/movies/1          	| /movies/{movieId}                  	| Delete Movie By Id         	|
| GET          	| http://localhost:9893/api/movies/1/quotes   	| /movies/{movieId}/quotes           	| Get all quotes by movie id 	|
| GET          	| http://localhost:9893/api/movies/1/quotes/1 	| /movies/{movieId}/quotes/{quoteId} 	| Get quote by id            	|
| POST         	| http://localhost:9893/api/movies/1/quotes   	| /movies/{movieId}/quotes           	| Create quote               	|
| PUT          	| http://localhost:9893/api/movies/1/quotes/1 	| /movies/{movieId}/quotes/{quoteId} 	| Update quote by id         	|
| DELETE       	| http://localhost:9893/api/movies/1/quotes/1 	| /movies/{movieId}/quotes/{quoteId} 	| Delete quote by id         	|

#### User Controller
| HTTP Methods 	| Full URL                                  	|          URL         	|   Functionally   	|
|--------------	|-------------------------------------------	|:--------------------:	|:----------------:	|
| POST         	| http://localhost:9893/auth/users/login    	| /auth/users/login    	| Logs user in     	|
| POST         	| http://localhost:9893/auth/users/register 	| /auth/users/register 	| Registers a user 	|


[Endpoint Planning Doc](https://docs.google.com/spreadsheets/d/1TMQIOrHQxaXZtsJ4rmfsd5t8xElu4gvIv6P-eFgEU1k/edit?usp=sharing)

---

## Learnings/ Takeaways

This project really tested my understanding of the Three-tier Architecture. As I started to add more controllers, services, and 
repositories, it became difficult for me to follow where/ how to call my methods.

I also struggled with the security portion in understanding which layers I was restricting to public vs private for users.

I'd like to be able to build on what I've already created here to be able to change endpoint access levels. Ideally I'd like to be able to also build out the DB for this 
so that I can use this API in creating a trivia game of sorts.

## Installation Instructions

You will need to install the following dependencies in your pom.xml file in order to use this codebase:

```
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>3.0.5</version>
    </dependency>
    
<!-- Postgres driver, make connection between db -->
    <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
    </dependency>
    
<!-- Allows you to talk to any db using Java -->
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
<!-- Spring Boot Security -->    
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency> 
```

## Credits

* Referred back to Java Spring Boot Lesson for explanations: https://git.generalassemb.ly/sureshmelvinsigera/Java-Spring-Boot-lecture/tree/spring-2-7-8
* [JAVA API](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
* [Spring Framework Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/)
* Trevor Hendricks - for helping me understand Spring logic/ MVC setup and being patient with explaining concepts.
* Kevin Barrios - for always helping me with my Github issues