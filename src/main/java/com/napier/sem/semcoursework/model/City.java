package com.napier.sem.semcoursework.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {
    @Id
    private Integer id;
    private String name;
    @Column(name = "country_code")
    private String countryCode;
    private String district;
    private Integer population;
}
