package com.napier.sem.semcoursework.controller;

import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.Population;
import com.napier.sem.semcoursework.repository.AdditionalCountryLevelPopulationRepository;
import com.napier.sem.semcoursework.repository.AdditionalCityLevelPopulationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling requests related to population.
 */
@RestController
@RequestMapping("/population")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AdditionalPopulationController {
    private final AdditionalCountryLevelPopulationRepository populationCountryLevelRepository;
    private final AdditionalCityLevelPopulationRepository populationCityLevelRepository;
    @GetMapping(value = "/population/world", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> populationWorld() {
        return new ResponseEntity<>(populationCountryLevelRepository.worldPopulation(), HttpStatus.OK);
    }


    /**
     *
     * @param continent is the sql where clause to query all countries in a particular continent
     * @return population of continent, with a http status of 200
     */
    @GetMapping(value = "/population/continent/{continent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> populationContinent(
            @PathVariable String continent
    ) {
        return new ResponseEntity<>(
                populationCountryLevelRepository.continentPopulation(continent), HttpStatus.OK);
    }



    /**
     *
     * @param region is the sql where clause to query population for a particular region
     * @return population of region, with a http status of 200
     */
    @GetMapping(value = "/population/region/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> populationRegion(
            @PathVariable String region
    ) {
        return new ResponseEntity<>(
                populationCountryLevelRepository.regionPopulation(region), HttpStatus.OK);
    }


    /**
     *
     * @param country is the sql where clause to query population for a particular country
     * @return population of country, with a http status of 200
     */
    @GetMapping(value = "/population/country/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> populationCountry(
            @PathVariable String country
    ) {
        return new ResponseEntity<>(
                populationCountryLevelRepository.countryPopulation(country), HttpStatus.OK);
    }



    /**
     *
     * @param district is the sql where clause to query population for a particular country
     * @return population of district, with a http status of 200
     */
    @GetMapping(value = "/population/district/{district}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> populationDistrict(
            @PathVariable String district
    ) {
        return new ResponseEntity<>(
                populationCityLevelRepository.districtPopulation(district), HttpStatus.OK);
    }

}
