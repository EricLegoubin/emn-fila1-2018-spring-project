package config.redis;

import org.emn.fila1.spring.model.Course;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;


@Configuration
public class RedisConfig {

	@Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
 
    @Bean
    public RedisTemplate<String, Course> redisTemplate() {
        RedisTemplate<String, Course> redisTemplate = new RedisTemplate<String, Course>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        
        return redisTemplate;
    }
} 