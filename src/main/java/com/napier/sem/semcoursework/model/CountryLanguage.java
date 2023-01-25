package com.napier.sem.semcoursework.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country_language")
public class CountryLanguage {
    @Id
    @Column(name = "country_code")
    private String countryCode;
    private String language;
    @Column(name = "is_official")
    private String isOfficial;
    private Double percentage;
}
