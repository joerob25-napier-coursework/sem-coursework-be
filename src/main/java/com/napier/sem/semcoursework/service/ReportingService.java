package com.napier.sem.semcoursework.service;

import com.napier.sem.semcoursework.model.City;
import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.CountryLanguage;
import com.napier.sem.semcoursework.repository.CityRepository;
import com.napier.sem.semcoursework.repository.CountryLanguageRepository;
import com.napier.sem.semcoursework.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportingService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final CountryLanguageRepository countryLanguageRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<CountryLanguage> getAllCountryLanguages() {
        return countryLanguageRepository.findAll();
    }

    public List<Country> allCountriesOrderedLargestToSmallest() {
        try {
            return countryRepository.allCountriesOrderedLargestToSmallest();
        } catch (Exception e) {
            return null;
        }
    }

}
