package com.codingmill.moviesapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest(
    classes = MoviesAPIApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Testcontainers
class MoviesAPIApplicationTest {

    @Container
    @ServiceConnection
    public static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:16.0");

    @Test
    void contextLoads() {
        Assertions.assertNotNull(postgresContainer);
    }

}