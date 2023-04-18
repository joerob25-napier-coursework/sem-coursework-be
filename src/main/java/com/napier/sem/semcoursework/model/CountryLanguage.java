package com.napier.sem.semcoursework.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CountryLanguage {
    @Id
    private String countryCode;
    private String language;
    private boolean isOfficial;
    private double percentage;

}
