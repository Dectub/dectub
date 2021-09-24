package com.dectub.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AggregateNotFoundExceptionTest {
    @Test
    void should_be_able_to_construct_from_loading_error() {
        AggregateNotFoundException exception = new AggregateNotFoundException("id-one", String.class, "collection-one");
        assertThat(exception).isInstanceOf(DomainException.class)
            .hasMessage("No aggregate with id 'id-one' and type 'String' found in collection 'collection-one'");
    }

    @Test
    void should_be_able_to_construct_from_loading_error_without_id() {
        AggregateNotFoundException exception = new AggregateNotFoundException(String.class, "collection-one");
        assertThat(exception).isInstanceOf(DomainException.class)
            .hasMessage("No aggregate with type 'String' found in collection 'collection-one'");
    }
}
