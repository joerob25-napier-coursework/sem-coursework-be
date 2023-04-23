package com.napier.sem.semcoursework.api;

public record CityResponse(
        String name,
        String country,
        String district,
        Integer population
) {
}
