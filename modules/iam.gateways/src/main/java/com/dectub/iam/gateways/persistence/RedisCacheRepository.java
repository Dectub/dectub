package com.dectub.iam.gateways.persistence;

import com.dectub.iam.domain.CacheRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/24 10:57 上午
 */
@Component
public class RedisCacheRepository implements CacheRepository {
    private @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(String key, Map<String, String> value) {
        redisTemplate.opsForHash().putAll(key, value);
    }

    @Override
    public String get(String mainKey, String mapKey) {
        return (String) redisTemplate.opsForHash().get(mainKey, mapKey);
    }

    @Override
    public String getForValue(String mainKey, String value) {
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(mainKey);
        Set<Object> objects = entries.keySet();
        for (Object object : objects) {
            if (value.equals(entries.get(object))) return (String) object;
        }
        return "";
    }

    @Override
    public void remove(String mainKey, String mapKey) {
        redisTemplate.opsForHash().delete(mainKey, mapKey);
    }
}
