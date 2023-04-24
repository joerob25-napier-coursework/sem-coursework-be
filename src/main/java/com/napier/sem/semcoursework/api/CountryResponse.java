package com.napier.sem.semcoursework.api;

public record CountryResponse(
        String code,
        String name,
        String continent,
        String region,
        Integer population,
        Integer capital) {
}
