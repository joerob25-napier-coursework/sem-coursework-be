package com.napier.sem.semcoursework.controller;


import com.napier.sem.semcoursework.model.City;
import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controller for handling requests related to cities.
 */

@RestController
@RequestMapping("/cities")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CityController {

    private final CityRepository cityRepository;

    /**
     * Endpoint method for retrieving a list of cities in order from largest to smallest.
     *
     * @return ResponseEntity with a list of City objects and an HTTP status of OK (200).
     */
    @GetMapping(value = "/report/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> cityReport1() {
        return new ResponseEntity<>(cityRepository.largestToSmallestCitiesWorld(), HttpStatus.OK);
    }

    /**
     * Endpoint method for retrieving a list of cities in a specific continent in order from largest to smallest.
     *
     * @param continent String representing the continent for which to retrieve city data.
     * @return ResponseEntity with a list of City objects and an HTTP status of OK (200).
     */
    @GetMapping(value = "/report/2/{continent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> cityReport2(@PathVariable String continent) {
        return new ResponseEntity<>(cityRepository.largestToSmallestCitiesContinent(continent), HttpStatus.OK);
    }

    /**
     * Endpoint method for retrieving a list of cities in a specific region in order from largest to smallest.
     *
     * @param region String representing the region for which to retrieve city data.
     * @return ResponseEntity with a list of City objects and an HTTP status of OK (200).
     */
    @GetMapping(value = "/report/3/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> cityReport3(@PathVariable String region) {
        return new ResponseEntity<>(cityRepository.largestToSmallestCitiesRegion(region), HttpStatus.OK);
    }

    /**
     * Endpoint method for retrieving a list of cities in a specific country in order from largest to smallest.
     *
     * @param country String representing the country for which to retrieve city data.
     * @return ResponseEntity with a list of City objects and an HTTP status of OK (200).
     */
    @GetMapping(value = "/report/4/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> cityReport4(@PathVariable String country) {
        return new ResponseEntity<>(cityRepository.largestToSmallestCitiesCountry(country), HttpStatus.OK);
    }

    /**
     * Endpoint method for retrieving a list of cities in a specific district in order from largest to smallest.
     *
     * @param district String representing the district for which to retrieve city data.
     * @return ResponseEntity with a list of City objects and an HTTP status of OK (200).
     */
    @GetMapping(value = "/report/5/{district}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> cityReport5(@PathVariable String district) {
        return new ResponseEntity<>(cityRepository.largestToSmallestCitiesDistrict(district), HttpStatus.OK);
    }

    /**
     * Handles the request for the top N cities in the world.
     *
     * @param n         the number of top cities to return
     * @return ResponseEntity containing the list of top N cities in the specified continent and an HTTP status code
     */

    @GetMapping(value = "/report/6/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> topNCities(
            @PathVariable int n
    ) {
        try {
            return new ResponseEntity<>(
                    cityRepository.topN(n), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }

    /**
     * Handles the request for the top N cities in a specified continent.
     *
     * @param n         the number of top cities to return
     * @param continent the specified continent
     * @return ResponseEntity containing the list of top N cities in the specified continent and an HTTP status code
     */

    @GetMapping(value = "/report/7/{n}/{continent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> topNCitiesInContinent(
            @PathVariable int n, @PathVariable String continent
    ) {
        try {
            return new ResponseEntity<>(
                    cityRepository.topNContinent(n, continent), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }

    /**
     * Handles the request for the top N cities in a specified region.
     *
     * @param n      the number of top cities to return
     * @param region the specified region
     * @return ResponseEntity containing the list of top N cities in the specified region and an HTTP status code
     */

    @GetMapping(value = "/report/8/{n}/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> topNCitiesInRegion(
            @PathVariable int n, @PathVariable String region
    ) {
        try {
            return new ResponseEntity<>(
                    cityRepository.topNCitiesRegion(n, region), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }

    /**
     * Handles the request for the top N cities in a specified country.
     *
     * @param n       the number of top cities to return
     * @param country the specified country
     * @return ResponseEntity containing the list of top N cities in the specified country and an HTTP status code
     */

    @GetMapping(value = "/report/9/{n}/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> topNCitiesInCountry(
            @PathVariable int n, @PathVariable String country
    ) {
        try {
            return new ResponseEntity<>(
                    cityRepository.topNCitiesCountry(n, country), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }

    /**
     * Handles the request for the top N cities in a specified district.
     *
     * @param n        the number of top cities to return
     * @param district the specified district
     * @return ResponseEntity containing the list of top N cities in the specified district and an HTTP status code
     */

    @GetMapping(value = "/report/10/{n}/{district}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> topNCitiesInDistrict(
            @PathVariable int n, @PathVariable String district
    ) {
        try {
            return new ResponseEntity<>(
                    cityRepository.topNCitiesDistrict(n, district), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }
}
