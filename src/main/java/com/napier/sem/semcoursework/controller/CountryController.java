package com.napier.sem.semcoursework.controller;

import com.napier.sem.semcoursework.api.CountryResponse;
import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author joe 40073047
 * Country controller exposes rest endpoints for country related reports
 */

@RestController
@RequestMapping("/countries")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CountryController {

    /**
     * CountryRepository is the interface to query database country table
     */
    private final CountryRepository countryRepository;

    /**
     *
     * @return list of countries in the world from largest to smallest in json format, with a Http Status of 200
     */
    @GetMapping(value = "/report/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponse>> allCountriesOrderedLargestToSmallest() {
        List<Country> countries = countryRepository.allCountriesOrderedLargestToSmallest();
        return new ResponseEntity<>(mapToResponse(countries), HttpStatus.OK);
    }

    /**
     *
     * @param continent is the sql where clause to query all countries in a particular continent
     * @return list of countries in a continent from largest to smallest in json format, with a http status of 200
     */
    @GetMapping(value = "/report/2/{continent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponse>> allCountriesInContinentOrderedLargestToSmallest(
            @PathVariable String continent
    ) {
        List<Country> countries = countryRepository.allCountriesInContinentOrderedLargestToSmallest(continent);
        return new ResponseEntity<>(mapToResponse(countries), HttpStatus.OK);
    }

    /**
     *
     * @param region is the sql where clause to query all countries in a particular region
     * @return list of countries in a region from largest to smallest in json format, with a http status of 200
     */
    @GetMapping(value = "/report/3/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponse>> allCountriesInRegionOrderedLargestToSmallest(
            @PathVariable String region
    ) {
        List<Country> countries = countryRepository.allCountriesInRegionOrderedLargestToSmallest(region);
        return new ResponseEntity<>(mapToResponse(countries), HttpStatus.OK);
    }

    /**
     *
     * @param n is the sql limit clause to limit the top N populated countries in the world
     * @return list of the top N populated countries in the world in json format, with a http status of 200
     */
    @GetMapping(value = "/report/4/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponse>> topNPopulatedCountries(
            @PathVariable int n
    ) {
        try {
            List<Country> countries = countryRepository.topNPopulatedCountries(n);
            return new ResponseEntity<>(mapToResponse(countries), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }

    /**
     *
     * @param n is the sql limit clause to limit the top N populated countries in a continent
     * @param continent is the sql where clause to query all countries in a particular continent
     * @return list of the top N populated countries in a particular continent in json format, with a http status of 200
     */
    @GetMapping(value = "/report/5/{n}/{continent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponse>> topNPopulatedCountriesInContinent(
            @PathVariable int n, @PathVariable String continent
    ) {
        try {
            List<Country> countries = countryRepository.topNPopulatedCountriesInContinent(n, continent);
            return new ResponseEntity<>(mapToResponse(countries), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }

    /**
     *
     * @param n is the sql limit clause to limit the top N populated countries in a region
     * @param region is the sql where clause to query all countries in a particular region
     * @return list of the top N populated countries in a particular region in json format, with a http status of 200
     */
    @GetMapping(value = "/report/6/{n}/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponse>> topNPopulatedCountriesInRegion(
            @PathVariable int n, @PathVariable String region
    ) {
        try {
            List<Country> countries = countryRepository.topNPopulatedCountriesInRegion(n, region);
            return new ResponseEntity<>(mapToResponse(countries), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }

    private List<CountryResponse> mapToResponse(List<Country> countries) {
        return countries
                .stream()
                .map(country ->
                        new CountryResponse(country.getCode(),
                                country.getName(),
                                country.getContinent(),
                                country.getRegion(),
                                country.getPopulation(),
                                country.getCapital()))
                .toList();
    }
}
