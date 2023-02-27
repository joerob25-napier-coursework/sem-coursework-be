package com.napier.sem.semcoursework.repository;

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
        return template.query(
                "select continent, ANY_VALUE(country.Population), ANY_VALUE(CONCAT(ROUND((city.population/country.population)*100,2),'%')) AS in_cities, ANY_VALUE(CONCAT(ROUND((((country.Population)-(city.Population))/(country.Population))*100,2),'%')) AS not_in_cities\n" +
                "from country\n" +
                        "JOIN city ON country.code=city.CountryCode\n" +
                        "GROUP BY continent",(rs,rowNum)-> Population.builder().continent(rs.getString("continent")).population(rs.getString("country.Population")).in_cities(rs.getString("in_cities")).not_in_cities(rs.getString("not_in_cities")).build());
    }
}