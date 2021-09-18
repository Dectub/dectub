package com.dectub.frameworks.application.core;


import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface UseCase {
    @AliasFor(attribute = "authorities")
    String[] value() default {};

    @AliasFor(attribute = "value")
    String[] authorities() default {};

    boolean authenticated() default false;
}
