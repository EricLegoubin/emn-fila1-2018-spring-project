package org.emn.fila1.spring.project;

import org.emn.fila1.spring.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class CopApplication {
	
	@Bean
    public JedisConnectionFactory jedisConnectionFactory() {
	    JedisConnectionFactory jedisCoFactory = new JedisConnectionFactory();
	    jedisCoFactory.setHostName("locahost");
	    jedisCoFactory.setPort(6379);
        return jedisCoFactory;
    }
 
    @Bean
    public RedisTemplate<String, Course> redisTemplate() {
        RedisTemplate<String, Course> redisTemplate = new RedisTemplate<String, Course>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        
        return redisTemplate;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(CopApplication.class, args);
	}
}
