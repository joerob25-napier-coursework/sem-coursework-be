package com.napier.sem.semcoursework.repository;

import com.napier.sem.semcoursework.model.CapitalCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CapitalCityRepository extends JpaRepository<CapitalCity, String> {

    /**
     * Retrieves a list of all cities in the world, sorted in descending order by population.
     *
     * @return a list of City objects.
     */
    @Query(value="SELECT city.name AS name, country.name AS country, city.population FROM city JOIN country ON city.country_code = country.code WHERE city.id = country.capital ORDER BY city.population DESC", nativeQuery = true)
    List<CapitalCity> largestToSmallestCapitalCitiesWorld();

    /**
     * Retrieves a list of cities on a continent, sorted in descending order by population.
     *
     * @param continent the name of the continent.
     * @return a list of City objects.
     */
    @Query(value="SELECT city.name AS name, country.name AS country, city.population FROM city JOIN country ON city.country_code = country.code WHERE city.id = country.capital AND continent = :continent ORDER BY city.population DESC", nativeQuery = true)
    List<CapitalCity> largestToSmallestCapitalCitiesContinent(@Param("continent") String continent);

    /**
     * Retrieves a list of cities in a region, sorted in descending order by population.
     *
     * @param region the name of the region.
     * @return a list of City objects.
     */
    @Query(value="SELECT city.name AS name, country.name AS country, city.population FROM city JOIN country ON city.country_code = country.code WHERE city.id = country.capital AND region = :region ORDER BY city.population DESC", nativeQuery = true)
    List<CapitalCity> largestToSmallestCapitalCitiesRegion(@Param("region") String region);

    /**
     * Query to retrieve data for the top N populated capital cities in the world
     * @param n provided by the user as the sql limit clause
     * @return list of capital cities
     */
    @Query(value = "SELECT city.name AS name, country.name AS country, city.population FROM city JOIN country ON city.country_code = country.code WHERE city.id = country.capital ORDER BY city.population DESC LIMIT :n", nativeQuery = true)
    List<CapitalCity> topNPopulatedCapitalCities(
            @Param("n") int n
    );

    /**
     * Query to retrieve data for the top N populated capital cities in a particular continent
     * @param n provided by the user as the sql limit clause
     * @param continent provided by the user as the sql where clause
     * @return list of capital cities
     */
    @Query(value = "SELECT city.name AS name, country.name AS country, city.population FROM city JOIN country ON city.country_code = country.code WHERE city.id = country.capital AND continent = :continent ORDER BY city.population DESC LIMIT :n", nativeQuery = true)
    List<CapitalCity> topNPopulatedCapitalCitiesInContinent(
            @Param("n") int n, @Param("continent") String continent
    );

    /**
     * Query to retrieve data for the top N populated capital cities in a particular region
     * @param n provided by the user as the sql limit clause
     * @param region provided by the user as the sql where clause
     * @return list of capital cities
     */
    @Query(value = "SELECT city.name AS name, country.name AS country, city.population FROM city JOIN country ON city.country_code = country.code WHERE city.name = country.capital AND region =  :region ORDER BY city.population DESC LIMIT :n", nativeQuery = true)
    List<CapitalCity> topNPopulatedCapitalCitiesInRegion(
            @Param("n") int n, @Param("region") String region
    );
}




