package com.codingmill.moviesapi;

import com.codingmill.moviesapi.database.repositories.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = TestDemoApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL",
        "spring.datasource.password=",
        "spring.datasource.username=sa"
    }
)
class MoviesAPIApplicationContextTests {

	@Autowired
	MovieRepository movieRepository;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(movieRepository);
	}

}
