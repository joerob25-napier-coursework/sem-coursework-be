package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.Population;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class represents a population repository that allows access to population data in the database.
 */

@Component
@RequiredArgsConstructor
public class PopulationRepository {
    /**
     *The JdbcTemplate instance used to query the database.
     */
    private final JdbcTemplate template;
/**
 *Retrieves population data for cities in each continent.
 */
    public List<Population> populationCitiesInContinent() {
        try {
            return template.query(
                    "select ANY_VALUE(continent), ANY_VALUE(country.Population), ANY_VALUE(CONCAT(ROUND((city.population/country.population)*100,2),'%')) AS in_cities, ANY_VALUE(CONCAT(ROUND((((country.Population)-(city.Population))/(country.Population))*100,2),'%')) AS not_in_cities FROM country JOIN city ON country.code=city.country_code GROUP BY ANY_VALUE(continent)", (rs,rowNum) -> Population.builder().continent(rs.getString("continent")).population(rs.getString("country.Population")).in_cities(rs.getString("in_cities")).not_in_cities(rs.getString("not_in_cities")).build());
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }
}