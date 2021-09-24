package com.dectub.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainExceptionTest {
    @Test
    void should_be_able_to_construct_from_message() {
        DomainException exception = new DomainException("a message");
        assertThat(exception).isInstanceOf(RuntimeException.class);
        assertThat(exception).hasMessage("a message");
    }

    @Test
    void should_be_able_to_construct_from_message_and_cause() {
        IllegalArgumentException cause = new IllegalArgumentException();
        DomainException exception = new DomainException("a message", cause);
        assertThat(exception).hasMessage("a message");
        assertThat(exception).hasCause(cause);
    }
}
