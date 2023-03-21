package com.napier.sem.semcoursework.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *This class represents a country object that contains country data in each continent/region/country.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Country {
    /**
     *The code of the ountry.
     */
    @Id
    @Column(name = "code")
    private String code;
    /**
     *The name of the country.
     */
    private String name;
    /**
     *The name of the continent.
     */
    private String continent;
    /**
     *The name of the region.
     */
    private String region;
    /**
     *The surface area of the country.
     */
    @Column(name = "surface_area")
    private Double surfaceArea;
    /**
     * The year the country gained independence
     */
    @Column(name = "indep_year")
    private Integer indepYear;
    /**
     *The population of the country.
     */
    private Integer population;
    /**
     *The life expectancy of the country.
     */
    @Column(name = "life_expectancy")
    private Double lifeExpectancy;
    /**
     *The gross national product of the country.
     */
    private Double gnp;
    /**
     *The old gross national product of the country.
     */
    @Column(name = "gnp_old")
    private Double gnpOld;
    /**
     *The local way of saying the country name.
     */
    @Column(name = "local_name")
    private String localName;
    /**
     *The government in power of the country.
     */
    @Column(name = "government_form")
    private String governmentForm;
    /**
     *The head of state of the country.
     */
    @Column(name = "head_of_state")
    private String headOfState;
    /**
     *The capital of the country.
     */
    private Integer capital;
    /**
     *The country code compressed to 2 letters
     */
    @Column(name = "code_2")
    private String code2;
}
