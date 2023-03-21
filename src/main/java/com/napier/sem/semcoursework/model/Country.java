package com.napier.sem.semcoursework.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *This class represents a country object that contains country data.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Country {

    @Id
    @Column(name = "code")
    private String code;
    private String name;
    private String continent;
    private String region;
    @Column(name = "surface_area")
    private Double surfaceArea;
    @Column(name = "indep_year")
    private Integer indepYear;
    private Integer population;
    @Column(name = "life_expectancy")
    private Double lifeExpectancy;
    private Double gnp;
    @Column(name = "gnp_old")
    private Double gnpOld;
    @Column(name = "local_name")
    private String localName;
    @Column(name = "government_form")
    private String governmentForm;
    @Column(name = "head_of_state")
    private String headOfState;
    private Integer capital;
    @Column(name = "code_2")
    private String code2;
}
