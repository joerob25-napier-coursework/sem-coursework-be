package com.napier.sem.semcoursework.controller;

import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.repository.CountryRepository;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(CountryController.class)
public class CountryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryRepository countryRepository;

    @Test
    public void getAllCountriesOrderedLargestToSmallest() throws Exception {
        // given countries
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        // when
        when(countryRepository.allCountriesOrderedLargestToSmallest()).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(countries.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(countries.get(1).getName()));
    }

    @Test
    public void getAllCountriesOrderedLargestToSmallest_noCountriesInTable() throws Exception {
        List<Country> countries = List.of();

        when(countryRepository.allCountriesOrderedLargestToSmallest()).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void allCountriesInContinentOrderedLargestToSmallest() throws Exception {
        String continent = "europe";
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        when(countryRepository.allCountriesInContinentOrderedLargestToSmallest(continent)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/2/"+ continent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(countries.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(countries.get(1).getName()));
    }

    @Test
    public void allCountriesInContinentOrderedLargestToSmallest_noContinentProvided() throws Exception {
        String continent = "";
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        when(countryRepository.allCountriesInContinentOrderedLargestToSmallest(continent)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/2/"+ continent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.NOT_FOUND.value()));
    }

    @Test
    public void allCountriesInContinentOrderedLargestToSmallest_noCountriesInTable() throws Exception {
        String continent = "europe";
        List<Country> countries = List.of();

        when(countryRepository.allCountriesInContinentOrderedLargestToSmallest(continent)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/2/"+ continent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void allCountriesInRegionOrderedLargestToSmallest() throws Exception {
        String region = "some_region";
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        when(countryRepository.allCountriesInRegionOrderedLargestToSmallest(region)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/3/"+ region)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(countries.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(countries.get(1).getName()));
    }

    @Test
    public void allCountriesInRegionOrderedLargestToSmallest_noContinentProvided() throws Exception {
        String region = "";
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        when(countryRepository.allCountriesInRegionOrderedLargestToSmallest(region)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/3/"+ region)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.NOT_FOUND.value()));
    }

    @Test
    public void allCountriesInRegionOrderedLargestToSmallest_noCountriesInTable() throws Exception {
        String region = "europe";
        List<Country> countries = List.of();

        when(countryRepository.allCountriesInRegionOrderedLargestToSmallest(region)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/3/"+ region)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void topNPopulatedCountries() throws Exception {
        int nPopulated = 2;
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        when(countryRepository.topNPopulatedCountries(nPopulated)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/4/"+ nPopulated)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(countries.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(countries.get(1).getName()));
    }

    @Test
    public void topNPopulatedCountries_nNotAnInt() throws Exception {
        String nPopulated = "aa";
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/4/"+ nPopulated)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void topNPopulatedCountries_noCountriesInTable() throws Exception {
        int nPopulated = 2;
        List<Country> countries = List.of();

        when(countryRepository.topNPopulatedCountries(nPopulated)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/4/"+ nPopulated)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void topNPopulatedCountriesInContinent() throws Exception {
        int nPopulated = 2;
        String continent = "some_continent";
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        when(countryRepository.topNPopulatedCountriesInContinent(nPopulated, continent)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(
                get("/countries/report/5/"+ nPopulated + "/" + continent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(countries.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(countries.get(1).getName()));
    }

    @Test
    public void topNPopulatedCountriesInContinent_nNotAnInt() throws Exception {
        String nPopulated = "aa";
        String continent = "some_continent";
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        MockHttpServletResponse response = mockMvc.perform(
                        get("/countries/report/5/"+ nPopulated + "/" + continent)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void topNPopulatedCountriesInContinent_noCountriesInTable() throws Exception {
        int nPopulated = 2;
        String continent = "some_continent";
        List<Country> countries = List.of();

        when(countryRepository.topNPopulatedCountriesInContinent(nPopulated, continent)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/countries/report/5/"+ nPopulated + "/" + continent)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void topNPopulatedCountriesInRegion() throws Exception {
        int nPopulated = 2;
        String region = "some_region";
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        when(countryRepository.topNPopulatedCountriesInRegion(nPopulated, region)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/countries/report/6/"+ nPopulated + "/" + region)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(countries.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(countries.get(1).getName()));
    }

    @Test
    public void topNPopulatedCountriesInRegion_nNotAnInt() throws Exception {
        String nPopulated = "aa";
        String region = "some_region";
        List<Country> countries = List.of(
                Country.builder().name("country1").build(),
                Country.builder().name("country2").build()
        );

        MockHttpServletResponse response = mockMvc.perform(
                        get("/countries/report/6/"+ nPopulated + "/" + region)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void topNPopulatedCountriesInRegion_noCountriesInTable() throws Exception {
        int nPopulated = 2;
        String region = "some_region";
        List<Country> countries = List.of();

        when(countryRepository.topNPopulatedCountriesInRegion(nPopulated, region)).thenReturn(countries);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/countries/report/6/"+ nPopulated + "/" + region)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }
}
