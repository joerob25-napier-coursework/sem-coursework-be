package com.napier.sem.semcoursework.controller;

import com.napier.sem.semcoursework.model.CapitalCity;
import com.napier.sem.semcoursework.repository.CapitalCityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controller for handling requests related to Capital cities.
 */

@RestController
@RequestMapping("/capitalcities")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CapitalCityController {

    private final CapitalCityRepository CapitalCityRepository;

    /**
     * Endpoint method for retrieving a list of Capital cities in order from largest to smallest.
     *
     * @return ResponseEntity with a list of Capital City objects and an HTTP status of OK (200).
     */

    @GetMapping(value = "/report/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CapitalCity>> largestToSmallestCapitalCitiesWorld(){
            return new ResponseEntity<>(CapitalCityRepository.largestToSmallestCapitalCitiesWorld(), HttpStatus.OK);
        }

    @GetMapping(value = "/report/2/{continent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CapitalCity>> largestToSmallestCapitalCitiesContinent (@PathVariable String continent) {
         return new ResponseEntity<>(CapitalCityRepository.largestToSmallestCapitalCitiesContinent(continent), HttpStatus.OK);
    }

    @GetMapping(value = "/report/3/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CapitalCity>> largestToSmallestCapitalCitiesRegion(@PathVariable String region) {
         return new ResponseEntity<>(CapitalCityRepository.largestToSmallestCapitalCitiesRegion(region), HttpStatus.OK);
    }
    /**
     *
     * @param n is the sql limit clause to limit the top N populated capital cities in the world
     * @return list of the top N populated capital cities in the world in json format, with a http status of 200
     */

    @GetMapping(value = "/report/4/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CapitalCity>> topNPopulatedCapitalCities(@PathVariable int n) {
    try {
        return new ResponseEntity<>(CapitalCityRepository.topNPopulatedCapitalCities(n), HttpStatus.OK);
    } catch (NumberFormatException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
    }
}
    /**
     *
     * @param n is the sql limit clause to limit the top N populated capital cities in a continent
     * @param continent is the sql where clause to query all capital cities in a particular continent
     * @return list of the top N populated capital cities in a particular continent in json format, with a http status of 200
     */
    @GetMapping(value = "/report/5/{n}/{continent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CapitalCity>> topNPopulatedCapitalCitiesInContinent(@PathVariable int n, @PathVariable String continent) {
        try {
            return new ResponseEntity<>(
                    CapitalCityRepository.topNPopulatedCapitalCitiesInContinent(n, continent), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }

    /**
     *
     * @param n is the sql limit clause to limit the top N populated capital cities in a region
     * @param region is the sql where clause to query all capital cities in a particular region
     * @return list of the top N populated capital cities in a particular region in json format, with a http status of 200
     */
    @GetMapping(value = "/report/6/{n}/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CapitalCity>> topNPopulatedCapitalCitiesInRegion(@PathVariable int n, @PathVariable String region) {
        try {
            return new ResponseEntity<>(
                    CapitalCityRepository.topNPopulatedCapitalCitiesInRegion(n, region), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a number");
        }
    }
}

