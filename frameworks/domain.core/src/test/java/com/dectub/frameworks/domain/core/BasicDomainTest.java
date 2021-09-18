package com.dectub.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:06 下午
 */
class BasicDomainTest {

    @Test
    void should_create_basic_domain_correctly() {
        assertThat(new BasicDomain(Instant.EPOCH, Instant.EPOCH).getCreateTime()).isEqualTo(Instant.EPOCH);
        assertThat(new BasicDomain(Instant.EPOCH, Instant.EPOCH).getUpdateTime()).isEqualTo(Instant.EPOCH);
    }

    @Test
    void should_basic_domain_update_time_correctly() {
        BasicDomain basicDomain = new BasicDomain(Instant.EPOCH, Instant.now());
        basicDomain.updateUpdateTime(Instant.EPOCH);
        assertThat(basicDomain.getUpdateTime()).isEqualTo(Instant.EPOCH);
        basicDomain.updateUpdateTime();
        assertThat(basicDomain.getUpdateTime()).isNotEqualTo(Instant.now());
    }

}
