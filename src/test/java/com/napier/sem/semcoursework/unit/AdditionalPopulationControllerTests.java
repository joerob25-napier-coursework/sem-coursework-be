package com.napier.sem.semcoursework.unit;

import com.napier.sem.semcoursework.controller.AdditionalPopulationController;
import com.napier.sem.semcoursework.repository.AdditionalCityLevelPopulationRepository;
import com.napier.sem.semcoursework.repository.AdditionalCountryLevelPopulationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Suzanne
 * Unit tests for the country related reports
 */

@ActiveProfiles("unit")
@RunWith(SpringRunner.class)
@WebMvcTest(AdditionalPopulationController.class)
public class AdditionalPopulationControllerTests {

    /**
     * MockMvc to mock http requests
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Stub of the AdditionalCityLevelPopulationRepository to mimic database queries
     */
    @MockBean
    private AdditionalCityLevelPopulationRepository cityLevelRepository;

    /**
     * Stub of the AdditionalCountryLevelPopulationRepository to mimic database queries
     */
    @MockBean
    private AdditionalCountryLevelPopulationRepository countryLevelRepository;

    /**
     * Test to ensure a HttpStatus of OK for a valid population/world request
     */
    @Test
    public void getWorldPopulation() throws Exception {
        Long worldPop = 12345678L;
        when(countryLevelRepository.worldPopulation()).thenReturn(worldPop);
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/world")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(worldPop.toString()));
    }

    /**
     * Test to ensure a HttpStatus of OK for a valid population/region/{region} request
     */
    @Test
    public void getRegionPopulation() throws Exception {
        String region = "europe";
        Long population = 123456L;

        when(countryLevelRepository.regionPopulation(region)).thenReturn(population);
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/region/"+ region)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(population.toString()));
    }

    /**
     * Test to ensure a HttpStatus of OK for a valid population/continent/{continent} request
     */
    @Test
    public void getContinentPopulation() throws Exception {
        String continent = "europe";
        Long population = 123456L;

        when(countryLevelRepository.continentPopulation(continent)).thenReturn(population);
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/continent/"+ continent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(population.toString()));
    }


    /**
     * Test to ensure a HttpStatus of OK for a valid population/country/{country} request
     */
    @Test
    public void getCountryPopulation() throws Exception {
        String country = "spain";
        Long population = 12346L;

        when(countryLevelRepository.countryPopulation(country)).thenReturn(population);
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/country/"+ country)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(population.toString()));
    }


    /**
     * Test to ensure a HttpStatus of OK for a valid population/district/{district} request
     */
    @Test
    public void getDistrictPopulation() throws Exception {
        String district = "manchester";
        Long population = 12346L;

        when(cityLevelRepository.districtPopulation(district)).thenReturn(population);
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/district/"+ district)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(population.toString()));
    }

    /**
     * Test to ensure a HttpStatus of OK for a valid population/city/{country} request
     */
    @Test
    public void getCityPopulation() throws Exception {
        String city = "manchester";
        Long population = Long.valueOf(12346);

        when(cityLevelRepository.cityPopulation(city)).thenReturn(population);
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/city/"+ city)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(population.toString()));
    }
}
