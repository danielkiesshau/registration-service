sleep 15
mysql -h localhost -u root -p
CREATE USER 'admin' IDENTIFIED BY 'java';
GRANT ALL PRIVILEGES ON . TO 'admin'@'%' WITH GRANT OPTION;
CREATE DATABASE db_registration_service;
