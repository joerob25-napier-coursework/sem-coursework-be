package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PopulationRepository extends JpaRepository<Population, Integer> {

    @Query(value="select continent, country.Population, CONCAT(ROUND((city.population/country.population)*100,2),'%') AS in_cities, CONCAT(ROUND((((country.Population)-(city.Population))/(country.Population))*100,2),'%') AS not_in_cities\n" +
            "from country\n" +
            "JOIN city ON country.code=city.CountryCode\n" +
            "GROUP BY continent",
            nativeQuery = true)
    List<Population> populationCitiesInContinent();
}