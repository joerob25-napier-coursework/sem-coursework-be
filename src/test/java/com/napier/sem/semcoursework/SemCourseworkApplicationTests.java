package com.napier.sem.semcoursework;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for context load including flyway script for database connectivity
 */
@ActiveProfiles("unit")
@SpringBootTest
class SemCourseworkApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}
}
