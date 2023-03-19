package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PopulationRepository extends JpaRepository <Population, String>{
    @Query(value = "select * from v_continent_population", nativeQuery = true)
    List<Population> populationOfContinentsLivingInCities();
}
