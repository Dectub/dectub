package com.dectub.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ExceptionsTest {
    @Test
    void should_wrap_checked_exception_for_void_functions() {
        Throwable exception = catchThrowable(() -> Exceptions.execute(() -> { throw new IOException(); }));
        assertThat(exception).isInstanceOf(RuntimeException.class);
        Exceptions.execute(() -> {});
    }

    @Test
    void should_keep_original_unchecked_exception_for_void_functions() {
        RuntimeException exceptionToThrow = new RuntimeException();
        Throwable exception = catchThrowable(() -> Exceptions.execute(() -> { throw exceptionToThrow; }));
        assertThat(exception).isSameAs(exceptionToThrow);
    }

    @Test
    void should_wrap_checked_exception_for_functions_with_result() {
        Throwable exception = catchThrowable(() -> Exceptions.evaluate(() -> { throw new IOException(); }));
        assertThat(exception).isInstanceOf(RuntimeException.class);
        Exceptions.evaluate(() -> "ok");
    }

    @Test
    void should_keep_original_unchecked_exception_for_functions_with_result() {
        RuntimeException exceptionToThrow = new RuntimeException();
        Throwable exception = catchThrowable(() -> Exceptions.evaluate(() -> { throw exceptionToThrow; }));
        assertThat(exception).isSameAs(exceptionToThrow);
    }
}
