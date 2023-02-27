package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author joe 40073047
 * CountryRepository is the JpaInterface to query the Country table in the world database
 */
public interface CountryRepository extends JpaRepository<Country, String> {

    /**
     * Query to retrieve data for all countries in the world from largest to smallest
     * @return list of countries
     */
    @Query(value = "select * from country order by population desc", nativeQuery = true)
    List<Country> allCountriesOrderedLargestToSmallest();

    /**
     * Query to retrieve data for all the countries in a continent from largest to smallest
     * @param continent provided by the user as the sql where clause
     * @return list of countries
     */
    @Query(value = "select * from country where continent = :continent order by population desc", nativeQuery = true)
    List<Country> allCountriesInContinentOrderedLargestToSmallest(
            @Param("continent") String continent);

    /**
     * Query to retrieve data for all the countries in a region from largest to smallest
     * @param region provided by the user as the sql where clause
     * @return list of countries
     */
    @Query(value = "select * from country where region = :region order by population desc", nativeQuery = true)
    List<Country> allCountriesInRegionOrderedLargestToSmallest(
            @Param("region") String region
    );

    /**
     * Query to retrieve data for the top N populated countries in the world
     * @param n provided by the user as the sql limit clause
     * @return list of countries
     */
    @Query(value = "select * from country order by population desc limit :n", nativeQuery = true)
    List<Country> topNPopulatedCountries(
            @Param("n") int n
    );

    /**
     * Query to retrieve data for the top N populated countries in a particular continent
     * @param n provided by the user as the sql limit clause
     * @param continent provided by the user as the sql where clause
     * @return list of countries
     */
    @Query(value = "select * from country where continent = :continent order by population desc limit :n", nativeQuery = true)
    List<Country> topNPopulatedCountriesInContinent(
            @Param("n") int n, @Param("continent") String continent
    );

    /**
     * Query to retrieve data for the top N populated countries in a particular region
     * @param n provided by the user as the sql limit clause
     * @param region provided by the user as the sql where clasue
     * @return list of countries
     */
    @Query(value = "select * from country where region = :region order by population desc limit :n", nativeQuery = true)
    List<Country> topNPopulatedCountriesInRegion(
            @Param("n") int n, @Param("region") String region
    );
}
