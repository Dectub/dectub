package com.dectub.frameworks.domain.core;

public class AggregateNotFoundException extends DomainException {
    public AggregateNotFoundException(String id, Class<?> aggregateType, String collection) {
        super(formatMessage(id, aggregateType, collection));
    }

    public <T> AggregateNotFoundException(Class<T> aggregateType, String collection) {
        super(formatMessage(aggregateType, collection));
    }

    private static <T> String formatMessage(Class<T> aggregateType, String collection) {
        var format = "No aggregate with type '%s' found in collection '%s'";
        return String.format(format, aggregateType.getSimpleName(), collection);
    }

    private static String formatMessage(String id, Class<?> aggregateType, String collection) {
        var format = "No aggregate with id '%s' and type '%s' found in collection '%s'";
        return String.format(format, id, aggregateType.getSimpleName(), collection);
    }
}
