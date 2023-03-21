package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author
 *
 */
public interface AdditionalCountryLevelPopulationRepository extends JpaRepository<Country, String> {

    /**
     * Query to retrieve world population
     * @return world population
     */
    @Query(value = "select sum(population) from country", nativeQuery = true)
    Long worldPopulation();

    /**
     * Query to retrieve population of a continent
     * @param continent provided by the user as the sql where clause
     * @return population of continent
     */
    @Query(value = "select sum(population) from country where continent = :continent", nativeQuery = true)
    Long continentPopulation(
            @Param("continent") String continent);

    /**
     * Query to retrieve population of all the countries in a region
     * @param region provided by the user as the sql where clause
     * @return population of region
     */
    @Query(value = "select sum(population) from country where region = :region", nativeQuery = true)
    Long regionPopulation(
            @Param("region") String region
    );

    /**
     * Query to retrieve population of a country
     * @param countryCode provided by the user as the sql where clause
     * @return population of country
     */
    @Query(value = "select sum(population) from country where code = :countryCode", nativeQuery = true)
    Long countryPopulation(
            @Param("countryCode") String countryCode
    );



}
