package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author
 *
 */
public interface AdditionalCityLevelPopulationRepository extends JpaRepository<City, String> {

    /**
     * Query to retrieve population of a district
     * @param district provided by the user
     * @return population of district
     */
    @Query(value = "select sum(population) from city where district = :district", nativeQuery = true)
    Long districtPopulation(
            @Param("district") String district
    );

    /**
     * Query to retrieve population of a city
     * @param cityName provided by the user
     * @return population of district
     */
    @Query(value = "select sum(population) from city where name = :cityName", nativeQuery = true)
    Long cityPopulation(
            @Param("cityName") String cityName
    );
}
