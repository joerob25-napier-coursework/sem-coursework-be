package com.napier.sem.semcoursework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Ensure that Spring is configured correctly and database connection to run the flyway
 */


@ActiveProfiles("unit")
@SpringBootTest
class SemCourseworkApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}
}
