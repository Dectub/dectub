package com.dechub.basic.gateways;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CanaryTest {
    @Test
    void should_be_able_to_run_tests() {
        assertThat("ok").isEqualTo("ok");
    }
}
