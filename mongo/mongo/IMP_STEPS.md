# Important Steps

Some of the important code components or setup is mentioned below.

---

## DBMS Setup

Personally used Docker for that. Command in cmd -

```bash
docker run --name mongo -d -p 27017:27017 mongo
```

(Default port: 27017)

---

## pom.xml Additions

In dependencies -

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

---

## application.properties

Example config -

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=testdb
```

---

## Repository

```java
public interface StudentRepository extends MongoRepository<Student, String> { }
```

---

## Important Tips

* Default database is `test` if not specified.
* Use MongoDB Compass to connect and explore collections.
* MongoDB is schema-less, documents can vary in fields.
* `@Document` replaces `@Entity` and `MongoRepository` replaces `JpaRepository`.
