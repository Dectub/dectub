package com.dectub.iam.application;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 2:48 下午
 */
public class CanaryTest {
    @Test
    void should_run_test_correctly() {
        assertThat("ok").isNotBlank();
    }
}
