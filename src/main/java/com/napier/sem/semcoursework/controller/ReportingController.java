package com.napier.sem.semcoursework.controller;

import com.napier.sem.semcoursework.model.City;
import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.CountryLanguage;
import com.napier.sem.semcoursework.service.ReportingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

\\ This class is the rest endpoints for the countries 

@RestController
@RequestMapping("/api/v1/world")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ReportingController {

    private final ReportingService reportingService;

    @GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Country>> getAllCountries() {
        return new ResponseEntity<>(reportingService.getAllCountries(), HttpStatus.OK);
    }

    @GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> getAllCities() {
        return new ResponseEntity<>(reportingService.getAllCities(), HttpStatus.OK);
    }

    @GetMapping(value = "/languages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryLanguage>> getAllCountryLanguages() {
        return new ResponseEntity<>(reportingService.getAllCountryLanguages(), HttpStatus.OK);
    }

    @GetMapping(value = "/country/report/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Country>> getAllCountriesOrderedLargestToSmallest() {
        return new ResponseEntity<>(reportingService.allCountriesOrderedLargestToSmallest(), HttpStatus.OK);
    }
}

