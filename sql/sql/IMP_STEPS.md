# Important Steps

Some of the important code components or setup is mentioned below.

## DBMS Setup
Personally used Docker for that. Command in cmd -
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_USER=sql-user -e 
MYSQL_PASSWORD=sql-password -e MYSQL_DATABASE=sql -p 3306:3306 -d mysql:latest

Also necessary to give privileges to sql-user as root-user -
GRANT ALL PRIVILEGES ON *.* TO 'sql-user'@'%';
FLUSH PRIVILEGES;

---


## pom.xml Additions
In dependencies -
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

In plugins -
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <excludes>
            <exclude>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
            </exclude>
        </excludes>
    </configuration>
</plugin>

---

## Application.properties
Example config -

spring.jpa.defer-datasource-initialization=true
spring.datasource.url=jdbc:mysql://localhost:3306/sql (DBMS URL)
spring.datasource.username=sql-user (USERNAME)
spring.datasource.password=sql-password (PASSWORD)
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

---

## Repository
public Interface CustomRepository extends JpaRepository<ClassName, PrimaryKeyDataType>

---

## Class Whose Table Is To Be Made
Lombok add the necessary components and class must be Entity. 
Primary Key must be Id. Can be GeneratedValue for automatic value generation.

---