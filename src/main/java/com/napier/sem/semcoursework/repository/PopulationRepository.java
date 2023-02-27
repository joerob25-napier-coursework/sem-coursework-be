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
                    "select continent, country.Population from country", (rs,rowNum) -> Population.builder().continent(rs.getString("continent")).population(rs.getString("country.Population")).build());
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }
}