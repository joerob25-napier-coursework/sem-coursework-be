package com.napier.sem.semcoursework.model.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public
class CompositeKey implements Serializable {
    private String countryCode;
    private String language;
}
