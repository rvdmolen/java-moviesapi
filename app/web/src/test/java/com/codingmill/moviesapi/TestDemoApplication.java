package com.codingmill.moviesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@TestConfiguration(proxyBeanMethods = false)

@SpringBootTest
@Testcontainers
public class TestDemoApplication {

    @TestConfiguration
    public static class ITTestConfiguration {
        @Bean
        @ServiceConnection
        public PostgreSQLContainer<?> postgresContainer( ){
            return new PostgreSQLContainer<>("postgres:16.0");
        }
    }

    public static void main(String[] args) {
        SpringApplication
            .from(MoviesAPIApplication::main)
            .with(ITTestConfiguration.class)
            .run(args);
    }

}
