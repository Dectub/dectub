package com.dectub;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TestContainersInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:12.6-alpine");
    private static final GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
            .withExposedPorts(6379);

    private static Map<String, Object> createConnectionConfiguration() {
        final String jdbcUrl = postgres.getJdbcUrl();
        String username = postgres.getUsername();
        String password = postgres.getPassword();
        Integer port = redis.getFirstMappedPort();
        return Map.of(
                "spring.datasource.url", jdbcUrl,
                "spring.datasource.username", username,
                "spring.datasource.password", password,
                "spring.redis.port", String.valueOf(port)
        );
    }

    private static void startContainers() {
        Startables.deepStart(Stream.of(postgres, redis)).join();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        startContainers();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        MapPropertySource testContainers = new MapPropertySource("testcontainers", createConnectionConfiguration());
        environment.getPropertySources().addFirst(testContainers);
    }

    public static boolean isRunning() {
        return postgres.isRunning() && redis.isRunning();
    }
}
