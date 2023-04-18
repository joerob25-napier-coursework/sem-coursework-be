package com.napier.sem.semcoursework;

import com.napier.sem.semcoursework.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public abstract class ITTemplate {

    @Container
    public static MySQLContainer<?> container = new MySQLContainer<>("mysql:latest")
            .withDatabaseName("integration")
            .withUsername("test")
            .withPassword("password");

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @Autowired
    protected CountryRepository countryRepository;

   @Autowired
   protected PopulationRepository populationRepository;

    @Autowired
    protected LanguageRepository languageRepository;

    @Autowired
    protected CapitalCityRepository capitalcityRepository;

    @Autowired
    protected CountryLanguageRepository countryLanguageRepository;

}
