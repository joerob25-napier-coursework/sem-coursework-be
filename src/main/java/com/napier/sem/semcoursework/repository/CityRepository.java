package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    /**
     * Retrieves a list of all cities in the world, sorted in descending order by population.
     *
     * @return a list of City objects.
     */
    @Query(value="select * from city order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesWorld();

    /**
     * Retrieves a list of cities on a continent, sorted in descending order by population.
     *
     * @param continent the name of the continent.
     * @return a list of City objects.
     */
    @Query(value="select * from city JOIN Country on city.country_code = country.code where continent = continent order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesContinent(@Param("continent") String continent);

    /**
     * Retrieves a list of cities in a region, sorted in descending order by population.
     *
     * @param region the name of the region.
     * @return a list of City objects.
     */
    @Query(value="select * from city Join Country on city.country_code = country.code where region = region order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesRegion(@Param("region") String region);

    /**
     * Retrieves a list of cities in a country, sorted in descending order by population.
     *
     * @param country the name of the country.
     * @return a list of City objects.
     */

    @Query(value="select * from city where country = :country order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesCountry(@Param("country") String country);

    /**
     * Retrieves a list of cities in a district, sorted in descending order by population.
     *
     * @param district the name of the district.
     * @return a list of City objects.
     */
    @Query(value="select * from city where district = :district order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesDistrict(@Param("district") String district);

    /**
     * Returns the top N most populous cities in a specified continent.
     *
     * @param n the number of cities to return
     * @param continent the continent to search for cities
     * @return a list of top N most populous cities in the specified continent
     */
    @Query(value="select * from city JOIN Country on city.country_code = country.code where continent = :continent order by population desc LIMIT :n", nativeQuery = true)
    List<City> topNContinent(@Param("n") int n, @Param("continent") String continent);

    /**
     * Returns the top N most populous cities in a specified region.
     *
     * @param n the number of cities to return
     * @param region the region to search for cities
     * @return a list of top N most populous cities in the specified region
     */
    @Query(value="select * from city Join Country on city.country_code = country.code where region = :region order by population desc LIMIT :n", nativeQuery = true)
    List<City> topNCitiesRegion(@Param("n") int n, @Param("region") String region);

    /**
     * Returns the top N most populous cities in a specified country.
     *
     * @param n the number of cities to return
     * @param country the country to search for cities
     * @return a list of top N most populous cities in the specified country
     */
    @Query(value="select * from city where country = :country order by population desc LIMIT :n", nativeQuery = true)
    List<City> topNCitiesCountry(@Param("n") int n, @Param("country") String country);

    /**
     * Returns the top N most populous cities in a specified district.
     *
     * @param n the number of cities to return
     * @param district the district to search for cities
     * @return a list of top N most populous cities in the specified district
     */
    @Query(value="select * from city where district = :district order by population desc LIMIT :n", nativeQuery = true)
    List<City> topNCitiesDistrict(@Param("n") int n, @Param("district") String district);

}
