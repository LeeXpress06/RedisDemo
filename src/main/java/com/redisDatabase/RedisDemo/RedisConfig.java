package com.redisDatabase.RedisDemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {


    @Bean
    public JedisConnectionFactory connectionJedis( ){
        RedisStandaloneConfiguration redis = new RedisStandaloneConfiguration();
        redis.setHostName("localhost");
        redis.setPort(9090);

        return new JedisConnectionFactory(redis);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate( ){

       RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();

       redisTemplate.setConnectionFactory(connectionJedis());
       redisTemplate.setKeySerializer(new StringRedisSerializer());
       redisTemplate.setHashKeySerializer(new StringRedisSerializer());
       redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
       redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
       redisTemplate.setEnableTransactionSupport(true);
       redisTemplate.afterPropertiesSet();


       return redisTemplate;

    }








}
