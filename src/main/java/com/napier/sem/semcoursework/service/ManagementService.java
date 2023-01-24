package com.napier.sem.semcoursework.service;

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
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/world")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ManagementService {

    private final CityRepository cityRepository;

    @GetMapping(value = "/cities",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> getAllCities() {
        return new ResponseEntity<>(cityRepository.findAll(), HttpStatus.OK);
    }
}
