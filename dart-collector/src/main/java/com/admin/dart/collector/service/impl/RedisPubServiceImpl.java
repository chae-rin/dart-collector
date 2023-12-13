package com.admin.dart.collector.service.impl;

import com.admin.dart.collector.service.RedisPubService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * REDIS PUBLISH 서비스
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RedisPubServiceImpl implements RedisPubService {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * 데이터 전파(publish)
     * @param channel
     * @param message
     */
    public void publish(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
    }

}
