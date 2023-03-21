package com.napier.sem.semcoursework.controller;

import com.napier.sem.semcoursework.model.Language;
import com.napier.sem.semcoursework.repository.LanguageRepository;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Keira 40345843
 * Language controller exposes rest endpoints for language related report
 */

@RestController
@RequestMapping("/language")
@CrossOrigin("*")
@RequiredArgsConstructor
public class LanguageController {

    /**
     * LanguageRepository is the interface to query database country_language table
     */
    private final LanguageRepository LanguageRepository;

    /**
     *
     * @return list of languages spoken from greatest number to smallest in json format, with a Http Status of 200
     */
    @GetMapping(value = "/report/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Language>> languagesOrderedLargestToSmallest() {
        return new ResponseEntity<>(LanguageRepository.languagesOrderedLargestToSmallest(), HttpStatus.OK);
    }
}
