package com.napier.sem.semcoursework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Ensure that Spring is configured correctly and database connection to run the flyway
 */

@Slf4j
@SpringBootTest
class SemCourseworkApplicationTests {

	@Test
	void contextLoads() {
		log.info("Running Flyway database migration");
		assertTrue(true);
	}
}
