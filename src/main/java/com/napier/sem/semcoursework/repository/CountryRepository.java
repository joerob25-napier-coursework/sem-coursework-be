package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Query(value = "select * from country order by population desc", nativeQuery = true)
    List<Country> allCountriesOrderedLargestToSmallest();

    @Query(value = "select * from country where continent = :continent order by population desc", nativeQuery = true)
    List<Country> allCountriesInContinentOrderedLargestToSmallest(
            @Param("continent") String continent);

    @Query(value = "select * from country where region = :region order by population desc", nativeQuery = true)
    List<Country> allCountriesInRegionOrderedLargestToSmallest(
            @Param("region") String region
    );

    @Query(value = "select * from country order by population desc limit :n", nativeQuery = true)
    List<Country> topNPopulatedCountries(
            @Param("n") int n
    );

    @Query(value = "select * from country where continent = :continent order by population desc limit :n", nativeQuery = true)
    List<Country> topNPopulatedCountriesInContinent(
            @Param("n") int n, @Param("continent") String continent
    );

    @Query(value = "select * from country where region = :region order by population desc limit :n", nativeQuery = true)
    List<Country> topNPopulatedCountriesInRegion(
            @Param("n") int n, @Param("region") String region
    );
}
