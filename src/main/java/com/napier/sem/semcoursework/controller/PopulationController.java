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

import java.util.List;

/**
 * Controller for handling requests related to population.
 */
@RestController
@RequestMapping("/population")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PopulationController {
}
