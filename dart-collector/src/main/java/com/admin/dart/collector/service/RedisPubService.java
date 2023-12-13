package com.admin.dart.collector.service;

/**
 * REDIS PUBLISH 서비스
 */
public interface RedisPubService {

    /**
     * 데이터 전파(publish)
     * @param channel
     * @param message
     */
    void publish(String channel, String message);
}
