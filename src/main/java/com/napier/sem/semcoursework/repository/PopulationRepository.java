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
//        try {
            return template.query(
                    "with continents_populations as (select code, continent, sum(population) as continent_population" +
                            "from country group by code, continent), cities_populations as (select country_code," +
                            "sum(population) as city_population from city group by country_code) select copops.continent," +
                            "coalesce(sum(copops.continent_population),0) as total_continent_population," +
                            "coalesce(sum(cipops.city_population),0) as total_in_city_population," +
                            "coalesce(sum((copops.continent_population-cipops.city_population)),0) as" +
                            "total_not_in_city_population from continents_populations copops left join cities_populations" +
                            "cipops on (copops.code = cipops.country_code) group by copops.continent",
                    (rs,rowNum) -> Population.builder().continent(rs.getString("continent")).population(rs.getString("total_continent_population")).in_cities(rs.getString("total_in_city_population")).not_in_cities(rs.getString("total_not_in_city_population")).build());
//        }catch (Exception e){
//            System.out.println(e.getLocalizedMessage());
//            return null;
//        }
    }
}