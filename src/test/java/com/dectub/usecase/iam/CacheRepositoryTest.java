package com.dectub.usecase.iam;

import com.dectub.IntegrationTest;
import com.dectub.iam.domain.CacheRepository;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/24 11:56 上午
 */
public class CacheRepositoryTest extends IntegrationTest {
    private @Resource
    CacheRepository cacheRepository;

    @Test
    void should_search_empty() {
        cacheRepository.save("test", Map.of("a", "b"));
        assertThat(cacheRepository.getForValue("test", "a")).isEmpty();
        cacheRepository.remove("test", "a");
    }
}
