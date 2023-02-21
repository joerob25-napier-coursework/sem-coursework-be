package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PopulationRepository extends JpaRepository<Population, Integer> {

    @Query(value="select continent, population, CONCAT(ROUND((city.population/population)*100,2),'%') AS in_cities," +
            "(population-in_cities)*100 AS not_in_cities from country JOIN city ON country.code=city.country_code",
            nativeQuery = true)
    List<Population> populationCitiesInContinent();
}