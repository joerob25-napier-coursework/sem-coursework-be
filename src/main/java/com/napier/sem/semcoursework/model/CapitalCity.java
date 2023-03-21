package com.napier.sem.semcoursework.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *This class represents a capital city object that contains capital city data in each continent/region/country.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CapitalCity {
    /**
     *The name of the capital city
     */
    @Id
    private String name;
    /**
     *The name of the country.
     */
    private String country;
    /**
     *The population of the capital city
     */
    private Integer population;
}

