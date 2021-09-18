package com.dectub.frameworks.security.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 5:07 下午
 */
public class CanaryTest {

    @Test
    void should_test_ok() {
        assertThat("ok").isNotBlank();
    }
}
