package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author keira 40345843
 * LanguageRepository is the JpaInterface to query the country_language table in the world database
 */
public interface LanguageRepository extends JpaRepository<Language, String> {

    /**
     * Query to retrieve data for languages spoken in the world from greatest to smallest
     *
     * @return list of languages
     */
    @Query(value = "SELECT language, SUM(population*percentage/100) AS number_of_speakers, ROUND(SUM(population*percentage/100)/(SELECT SUM(population) FROM country)*100, 2) AS percentage_of_world_population FROM country JOIN country_language ON code=country_code WHERE language In ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') GROUP BY language ORDER BY number_of_speakers DESC", nativeQuery = true)
    List<Language> languagesOrderedLargestToSmallest();
}
