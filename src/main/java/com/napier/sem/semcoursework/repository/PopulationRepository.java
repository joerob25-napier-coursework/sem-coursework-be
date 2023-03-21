package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 The PopulationRepository interface provides methods for querying population data
 from the database using Spring
 */

public interface PopulationRepository extends JpaRepository <Population, String>{

    /**
     * Returns a list of Population containing population data for all continents
     * living in cities
     */
    @Query(value = "select * from v_continent_population", nativeQuery = true)
    List<Population> populationOfContinentsLivingInCities();

    /**
     * Returns a list of Population containing population data for all regions
     * living in cities
     */
    @Query(value = "select * from v_region_population", nativeQuery = true)
    List<Population> populationOfRegionLivingInCities();

    /**
     * Returns a list of Population containing population data for all countries
     * living in cities
     */
    @Query(value = "select * from v_country_population", nativeQuery = true)
    List<Population> populationOfCountryLivingInCities();
}
