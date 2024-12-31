# Important Steps

Some of the important code components or setup is mentioned below.

## DBMS Setup
Personally used Docker for that. Command in cmd -
docker run --name psql -e POSTGRES_USER=psql-user -e POSTGRES_PASSWORD=psql-password -d -p 5432:5432 postgres

---

## pom.xml Additions
In dependencies -
<dependency>
<groupId>org.postgresql</groupId>
<artifactId>postgresql</artifactId>
<scope>runtime</scope>
</dependency>

---

## Application.properties
Example config -

spring.datasource.url=jdbc:postgresql://localhost:5432/psql
spring.datasource.username=psql-user (USERNAME)
spring.datasource.password=psql-password (PASSWORD)
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true

---

## Repository
public Interface CustomRepository extends JpaRepository<ClassName, PrimaryKeyDataType>

---

## Class Whose Table Is To Be Made
Lombok add the necessary components and class must be Entity. 
Primary Key must be Id. Can be GeneratedValue for automatic value generation.

---

## Important Tips
- The table must be made before itself, it cannot be made by Spring.
- Can use pgAdmin4 for connecting to database and making table.
- User cannot be the name of table, Postgresql has user as keyword, so use non keyword names for tables.