package com.dectub;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CanaryTest extends IntegrationTest {
    @Test
    void should_be_able_to_run_spring_tests() {
        assertThat("Use-case test environment OK").isNotBlank();
    }
}
