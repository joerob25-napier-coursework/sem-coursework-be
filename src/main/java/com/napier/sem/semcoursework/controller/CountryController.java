package com.napier.sem.semcoursework.controller;

import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


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
    public ResponseEntity<List<Country>> allCountriesOrderedLargestToSmallest() {
        return new ResponseEntity<>(countryRepository.allCountriesOrderedLargestToSmallest(), HttpStatus.OK);
    }

    /**
     *
     * @param continent is the sql where clause to query all countries in a particular continent
     * @return list of countries in a continent from largest to smallest in json format, with a http status of 200
     */
    @GetMapping(value = "/report/2/{continent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Country>> allCountriesInContinentOrderedLargestToSmallest(
            @PathVariable String continent
    ) {
        return new ResponseEntity<>(
                countryRepository.allCountriesInContinentOrderedLargestToSmallest(continent), HttpStatus.OK);
    }

    /**
     *
     * @param region is the sql where clause to query all countries in a particular region
     * @return list of countries in a region from largest to smallest in json format, with a http status of 200
     */
    @GetMapping(value = "/report/3/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Country>> allCountriesInRegionOrderedLargestToSmallest(
            @PathVariable String region
    ) {
        return new ResponseEntity<>(
                countryRepository.allCountriesInRegionOrderedLargestToSmallest(region), HttpStatus.OK);
    }

    /**
     *
     * @param n is the sql limit clause to limit the top N populated countries in the world
     * @return list of the top N populated countries in the world in json format, with a http status of 200
     */
    @GetMapping(value = "/report/4/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Country>> topNPopulatedCountries(
            @PathVariable int n
    ) {
        try {
            return new ResponseEntity<>(countryRepository.topNPopulatedCountries(n), HttpStatus.OK);
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
    public ResponseEntity<List<Country>> topNPopulatedCountriesInContinent(
            @PathVariable int n, @PathVariable String continent
    ) {
        try {
            return new ResponseEntity<>(
                    countryRepository.topNPopulatedCountriesInContinent(n, continent), HttpStatus.OK);
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
    public ResponseEntity<List<Country>> topNPopulatedCountriesInRegion(
            @PathVariable int n, @PathVariable String region
    ) {
        try {
            return new ResponseEntity<>(
                    countryRepository.topNPopulatedCountriesInRegion(n, region), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }
}
