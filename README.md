# Movie Quotes API

## Spring Boot Mini-Project
* <a href="#"></a>
* <a href="#"></a>
* <a href="#"></a>
* <a href="#"></a>
* <a href="#"></a>
* <a href="#"></a>
* <a href="#"></a>
---
## 

Text Here

##

Text Here

---
## 

---
## 

### User Stories
- [x] As a User, I want to be able to create an account, so I can have a user profile.
- [x] As a User, I want to have a list of many movies in my account.
- [x] As a User, I want to add many Movies so that I can have many notable quotes.
- [x] As a User, I want certain information accessible only to me.

### Technical Requirements

---
## Project Planning Process

### ERD Diagram
![](/images/DB_ER_diagram.png)

### Kanban/ Agile Approach
![](/images/agile_project_plan.png)

### Functionality/ REST API Endpoints

#### Movie Controller
| HTTP Methods | Full URL                           |    URL    |    Functionally    |
|--------------|------------------------------------|:---------:|:------------------:|
| GET          | http://localhost:9893/api/movies/  | /movies/  | Get All movies     |
| GET          | http://localhost:9893/api/movies/1 | /movies/1 | Get Movie By Id    |
| POST         | http://localhost:9893/api/movies/  | /movies/  | Create Movie       |
| PUT          | http://localhost:9893/api/movies/1 | /movies/1 | Update Movie By Id |
| DELETE       | http://localhost:9893/api/movies/1 | /movies/1 | Delete Movie By Id |

#### User Controller
| HTTP Methods | Full URL                                  |          URL         |   Functionally   |
|--------------|-------------------------------------------|:--------------------:|:----------------:|
| POST         | http://localhost:9893/auth/users/login    | /auth/users/login    | Logs user in     |
| POST         | http://localhost:9893/auth/users/register | /auth/users/register | Registers a user |


[Endpoint Planning Doc](https://docs.google.com/spreadsheets/d/1TMQIOrHQxaXZtsJ4rmfsd5t8xElu4gvIv6P-eFgEU1k/edit?usp=sharing)

---
### Learnings/ Takeaways

## Credits

* 