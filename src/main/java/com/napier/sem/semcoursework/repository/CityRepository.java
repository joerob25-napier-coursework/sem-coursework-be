package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value="select name, country, district, population from city order by population desc", nativeQuery = true)
    List<City> largestToSmallestCities();

    @Query(value="select name, country, district, population from city where " +
            "continent = :continent order by population", nativeQuery = true)
    List<City> smallestToLargestCities(@Param("continent") String continent);







}
