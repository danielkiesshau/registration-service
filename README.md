# Registration Service
CRUD application to manage patient and medical history.

## Setup

### 1. Run MySQL server
```shell
 cd mysql
 docker-compose up
```

### 2. Run application
`/src/main/java/com/br/healthCare/registrationService/appRunner/ApplicationRunner.java`


### 3. Test the rest API with your preferred method
`curl localhost:8080/<endpoint>`

### Useful commands
```
docker exec -it db-registration-service-7 bash   ## connects to mysql container's bash
```
```
docker logs db-registration-service-7 --follow   ## logs from mysql container
```
```
mysql -u root -p     ## execute mysql CLI do be able to run SQL Queries
```

## --- Comandos CLI SQL ---
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
