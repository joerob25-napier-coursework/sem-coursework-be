package com.napier.sem.semcoursework.controller;

import com.napier.sem.semcoursework.model.Population;
import com.napier.sem.semcoursework.repository.PopulationRepository;
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
public class PopulationController {
    private final PopulationRepository populationRepository;
    @GetMapping(value = "/report/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Population>> populationCitiesInContinent() {
        return new ResponseEntity<>(populationRepository.populationOfContinentsLivingInCities(), HttpStatus.OK);
    }
}
