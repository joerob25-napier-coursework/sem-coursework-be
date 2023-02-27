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
    @Query(value="select * from city where continent = :continent order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesContinent(@Param("continent") String continent);

    /**
     * Retrieves a list of cities in a region, sorted in descending order by population.
     *
     * @param region the name of the region.
     * @return a list of City objects.
     */
    @Query(value="select * from city where region = :region order by population desc", nativeQuery = true)
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



}
