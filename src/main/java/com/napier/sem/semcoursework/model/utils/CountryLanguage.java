package com.napier.sem.semcoursework.model.utils;

import com.napier.sem.semcoursework.model.utils.CompositeKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
    @EmbeddedId
    private CompositeKey compositeKey;
    private boolean isOfficial;
    private double percentage;

}

