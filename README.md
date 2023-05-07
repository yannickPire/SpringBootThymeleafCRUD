# SpringBootThymeleafCRUD

This project is about a small CRUD appliction which is created in Spring Boot with a Thymeleaf Front End.
I also implemented Spring AOP for logging and Form Validations in Java, through Validation Annotations and Thymeleaf.

## Setup
### Docker
This project makes use of Docker in the form of a Docker Container which contains the local database.
This is done for ease of setting up the environment quickly via a Docker-compose file. This docker compose file uses the mysql image

To set up a local database run following commands

```console
foo@bar SpringBootThymeleafCRUD % cd database/initial/ 
foo@bar initial % docker-compose build
foo@bar initial % docker-compose up -d
```

### Flyway
This project makes use of the Flyway Maven plugin which makes implementing db changes very easy. 

A new Maven configuration should be created
```maven
-Dflyway.configFiles=myFlywayConfig.conf flyway:migrate
```