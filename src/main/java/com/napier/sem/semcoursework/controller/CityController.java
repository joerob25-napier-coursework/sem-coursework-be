package com.napier.sem.semcoursework.controller;


import com.napier.sem.semcoursework.model.City;
import com.napier.sem.semcoursework.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
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

        return new ResponseEntity<>(cityRepository.largestToSmallestCities(), HttpStatus.OK);

    }

}
