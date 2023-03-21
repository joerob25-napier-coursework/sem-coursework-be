package com.napier.sem.semcoursework.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *This class represents a city object that contains city data.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {
    /**
     *The id of the city
     */
    @Id
    private Integer id;
    /**
     *The name of the city.
     */
    private String name;
    /**
     *The code of the country the city is in.
     */
    @Column(name = "country_code")
    private String countryCode;
    /**
     *The name of the district.
     */
    private String district;
    /**
     *The population of the city
     */
    private Integer population;
}
