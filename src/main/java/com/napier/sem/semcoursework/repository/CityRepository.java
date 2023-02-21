package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value="select name, country, district, population from city order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesWorld();

    @Query(value="select name, country, district, population from city where continent = :continent order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesContinent(@Param("continent") String continent);


    @Query(value="select name, country, district, population from city where region = :region order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesRegion(@Param("region") String region);

    @Query(value="select name, country, district, population from city where country = :country order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesCountry(@Param("country") String country);

    @Query(value="select name, country, district, population from city where district = :district order by population desc", nativeQuery = true)
    List<City> largestToSmallestCitiesDistrict(@Param("district") String district);



}
