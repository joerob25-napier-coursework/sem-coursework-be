package com.napier.sem.semcoursework.controller;

import com.napier.sem.semcoursework.model.City;
import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.CountryLanguage;
import com.napier.sem.semcoursework.service.ReportingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(ReportingController.class)
public class ReportingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ReportingService reportingService;

    @Test
    public void getAllCountries() throws Exception {
        //given
        Country country = Country.builder().name("Portugal").build();

        //when
        when(reportingService.getAllCountries()).thenReturn(List.of(country));
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/world/countries")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(country.getName()));
    }

    @Test
    public void getAllCities() throws Exception {
        //given
        City city = City.builder().name("Edinburgh").build();

        //when
        when(reportingService.getAllCities()).thenReturn(List.of(city));
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/world/cities")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(city.getName()));
    }

    @Test
    public void getAllCountryLanguages() throws Exception {
        //given
        CountryLanguage countryLanguage = CountryLanguage.builder().language("French").build();

        //when
        when(reportingService.getAllCountryLanguages()).thenReturn(List.of(countryLanguage));
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/world/languages")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(countryLanguage.getLanguage()));
    }

    @Test
    public void getAllCountriesOrderedLargestToSmallest() throws Exception {
        //given
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        //when
        when(reportingService.allCountriesOrderedLargestToSmallest()).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/world/country/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(countries.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(countries.get(1).getName()));
    }

}
