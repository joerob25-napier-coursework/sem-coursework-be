package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.Population;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class PopulationRepository {
    private final JdbcTemplate template;
    public List<Population> populationCitiesInContinent() {
        try {
            return template.query(
                    "select continent, country.Population, CONCAT(ROUND((city.population/country.population)*100,2),'%') AS in_cities, CONCAT(ROUND((((country.Population)-(city.Population))/(country.Population))*100,2),'%') AS not_in_cities FROM country JOIN city ON country.code=city.country_code GROUP BY country.continent", (rs,rowNum) -> Population.builder().continent(rs.getString("continent")).population(rs.getString("country.Population")).in_cities(rs.getString("in_cities")).not_in_cities(rs.getString("not_in_cities")).build());
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }
}