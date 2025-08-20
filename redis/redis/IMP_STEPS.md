# Important Steps

Some of the important code components or setup is mentioned below.

---

## DBMS Setup

Personally used Docker for that. Command in cmd -

```bash
docker run --name redis -d -p 6379:6379 redis
```

(Default port: 6379)

---

## pom.xml Additions

In dependencies -

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

---

## application.properties

Example config -

```properties
spring.redis.host=localhost
spring.redis.port=6379
```

---

## Configuration

```java
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
```

## Important Tips

* Redis stores **key–value pairs**, not tables/collections.
* Common access pattern is with `opsForValue()` (string/JSON).
* Keys are often prefixed (e.g., `student:<id>`).
* Default port is **6379**.
