# Registration Service
CRUD application to manage patient and medical history.


## Steps to Run

1. Run MySQL server
```shell
 cd mysql
 docker-compose up
```

2. Run application
`/src/main/java/com/br/healthCare/registrationService/appRunner/ApplicationRunner.java`


3. Test the rest API with your preferred method

#### Suggestion:
Import JSON collection into your postman [http://localhost:8080/v2/api-docs](http://localhost:8080/v2/api-docs)

## Swagger

Swagger is under [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

It will show all CRUD endpoints for Patient and MedicalHistory


#### Applied Design Patterns
1. DAO - Access to database data
2. Repository - Database queries
3. Controller - Request/Response handling
4. Command - Business Rules
5. SOLID
6. Scaffold inspired by Clean Architecture


### Useful commands

#### --- Docker commands ---
```
docker exec -it db-registration-service bash   ## connects to mysql container's bash
```
```
docker logs db-registration-service --follow   ## logs from mysql container
```

#### --- Bash commands ---
```
mysql -u root -p     ## execute mysql CLI do be able to run SQL Queries
```

#### --- MySQL commands ---
```
USE DATABASE db_registration_service;
```
```
SHOW TABLES;
```
```
SHOW COLUMNS FROM TABLE <table-name>;
```
```
[QUERY - EXEMPLO:] SELECT * FROM patient; 
```


