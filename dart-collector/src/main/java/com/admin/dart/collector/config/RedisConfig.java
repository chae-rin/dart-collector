package com.admin.dart.collector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * REDIS 설정
 */
@Configuration
public class RedisConfig {

  private final RedisConnectionFactory redisConnectionFactory;

  public RedisConfig(RedisConnectionFactory redisConnectionFactory) {
    this.redisConnectionFactory = redisConnectionFactory;
  }

  public RedisConnectionFactory getRedisConnectionFactory() {
    return this.redisConnectionFactory;
  }

  @Bean
  public RedisTemplate<?, ?> redisTemplate() {
    
    RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new StringRedisSerializer());
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashValueSerializer(new StringRedisSerializer());
    redisTemplate.setConnectionFactory(getRedisConnectionFactory());
    return redisTemplate;
  }

}
