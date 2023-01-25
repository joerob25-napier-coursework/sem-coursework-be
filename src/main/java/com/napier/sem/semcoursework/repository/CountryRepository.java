package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Query(value = "select * from country order by population desc", nativeQuery = true)
    List<Country> allCountriesOrderedLargestToSmallest();
}
