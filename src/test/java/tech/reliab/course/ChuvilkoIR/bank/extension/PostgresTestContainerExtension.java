package tech.reliab.course.ChuvilkoIR.bank.extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.PostgreSQLContainer;

import static java.lang.System.setProperty;

public class PostgresTestContainerExtension implements BeforeAllCallback, AfterAllCallback {
    private static PostgreSQLContainer<?> postgres;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (postgres == null) {
            postgres = new PostgreSQLContainer<>("postgres:16");
        }
        if (!postgres.isRunning()) {
            postgres.start();
        }

        setProperty("spring.datasource.url", postgres.getJdbcUrl());
        setProperty("spring.datasource.username", postgres.getUsername());
        setProperty("spring.datasource.password", postgres.getPassword());
    }

    @Override
    public void afterAll(ExtensionContext context) {
        if (postgres != null) {
            postgres.stop();
        }
    }
}
