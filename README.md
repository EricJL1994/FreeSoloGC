# Medical History
Project for the subjects _Agile Development Methodologies_ and _Software Architecture_

## Description
This application will be implemented to manage the medical history of the patients.

## Configuration for PostgreSQL

### Without Docker

1. You will need to install *postgres* in your machine and configure it.
2. Update your *application.properties* file according to your local *postgres* configuration

### With Docker

1. Build the *postgresql* image called medicalhistory_db

    `docker build -t medicalhistory_db src/main/docker`
    
2. Run the container

    `docker run --name medicalhistory_postgres -p 5432:5432 -d medicalhistory_db`
    
3. Verify if the container is running

    `docker ps`
    
4. Verify that the environment variables in *Dockerfile* are the same in your *application.properties* file 

    * spring.datasource.url= jdbc:postgresql://localhost:5432/medicalhistory
    * spring.datasource.username=postgres
    * spring.datasource.password=mysecretpassword
    
5. Execute the sql schema in your database

    * You have the DDL in `src/main/resources/db/db_schema.sql`
    
6. Enjoy coding!

7. If you want to stop your container:

    `docker stop medicalhistory_postgres`

8. If you want to restart the container:
    
    `docker restart medicalhistory_postgres`
