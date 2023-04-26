package com.napier.sem.semcoursework.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

/**
 *This class represents a population object that contains population data for cities in each continent/region/country
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Immutable
public class Population {

    /**
     *The name of the continent/region/country.
     */
    @Id
    private String qID;

    /**
     *The total population of the continent/region/country.
     */
    private Long population;

    /**
     *The percentage of the population living in cities.
     */
    private Long in_cities;

    /**
     *The percentage of the population not living in cities.
     */
    private Long not_in_cities;
}
