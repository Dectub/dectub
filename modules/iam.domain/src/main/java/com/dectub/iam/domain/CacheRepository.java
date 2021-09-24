package com.dectub.iam.domain;

import java.util.Map;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/24 10:50 上午
 */
public interface CacheRepository {
    void save(String key, Map<String, String> value);
    String get(String mainKey, String mapKey);
    String getForValue(String mainKey, String value);
    void remove(String mainKey, String mapKey);
}
