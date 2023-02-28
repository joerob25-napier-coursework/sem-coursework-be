package com.napier.sem.semcoursework.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *This class represents a population object that contains population data for cities in each continent.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Population {
    /**
     *The name of the continent.
     */
    private String continent;
    /**
     *The total population of the continent.
     */
    private String population;
    /**
     *The percentage of the population living in cities.
     */
    private String in_cities;
    /**
     *The percentage of the population not living in cities.
     */
    private String not_in_cities;
}
