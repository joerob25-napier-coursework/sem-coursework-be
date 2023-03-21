package com.napier.sem.semcoursework.unit.controller;

import com.napier.sem.semcoursework.controller.CapitalCityController;
import com.napier.sem.semcoursework.model.CapitalCity;
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

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Keira 40345843
 * Unit tests for the language related reports
 */

@ActiveProfiles("unit")
@RunWith(SpringRunner.class)
@WebMvcTest(CapitalCityController.class)
public class CapitalCityControllerTest {

    /**
     * MockMvc to mock http requests
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Stub of the CapitalCityRepository to mimic database queries
     */
    @MockBean
    private com.napier.sem.semcoursework.repository.CapitalCityRepository CapitalCityRepository;

    /**
     * Test to ensure a HttpStatus of OK for a valid report 1 request
     */
    @org.junit.Test
    public void getLargestToSmallestCapitalCitiesWorld() throws Exception {
        List<CapitalCity> capitalCities = List.of(
                CapitalCity.builder().name("capitalCities1").build()
        );

        when(CapitalCityRepository.largestToSmallestCapitalCitiesWorld()).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(0).getName()));
    }

    /**
     * Test to ensure a HttpStatus of OK with no data in the city table for a valid report 1 request
     */
    @org.junit.Test
    public void largestToSmallestCapitalCitiesWorld_noCitiesInTable() throws Exception {
        List<CapitalCity> capitalCities = List.of();

        when(CapitalCityRepository.largestToSmallestCapitalCitiesWorld()).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();
        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    /**
     * Test to ensure a HttpStatus of OK for a valid report 2 request
     */
    @Test
    public void getLargestToSmallestCapitalCitiesContinent() throws Exception {
        String continent = "europe";
        List<CapitalCity> capitalCities = List.of(
                CapitalCity.builder().name("capitalCities1").build(),
                CapitalCity.builder().name("capitalCities2").build()
        );

        when(CapitalCityRepository.largestToSmallestCapitalCitiesContinent(continent)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/2/"+ continent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(1).getName()));
    }

    /**
     * Test to ensure a HttpStatus of NOT FOUND for an invalid continent report 2 request
     */
    @Test
    public void largestToSmallestCapitalCitiesContinent_noContinentProvided() throws Exception {
        String continent = "";
        List<CapitalCity> capitalCities = List.of(
                CapitalCity.builder().name("capitalCities1").build(),
                CapitalCity.builder().name("capitalCities2").build()
        );

        when(CapitalCityRepository.largestToSmallestCapitalCitiesContinent(continent)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/2/"+ continent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.NOT_FOUND.value()));
    }

    /**
     * Test to ensure a HttpStatus of OK with no data in city table for a valid report 2 request
     */
    @Test
    public void largestToSmallestCapitalCitiesContinent_noCountriesInTable() throws Exception {
        String continent = "europe";
        List<CapitalCity> capitalCities = List.of();

        when(CapitalCityRepository.largestToSmallestCapitalCitiesContinent(continent)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/2/"+ continent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    /**
     * Test to ensure a HttpStatus of OK for a valid report 3 request
     */
    @Test
    public void getLargestToSmallestCapitalCitiesRegion() throws Exception {
        String region = "some_region";
        List<CapitalCity> capitalCities = List.of(
                CapitalCity.builder().name("capitalCities1").build(),
                CapitalCity.builder().name("capitalCities2").build()
        );

        when(CapitalCityRepository.largestToSmallestCapitalCitiesRegion(region)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/3/"+ region)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(1).getName()));
    }

    /**
     * Test to ensure a HttpStatus of NOT FOUND for an invalid continent report 3 request
     */
    @Test
    public void largestToSmallestCapitalCitiesRegion_noRegionProvided() throws Exception {
        String region = "";
        List<CapitalCity> capitalCities = List.of(
                CapitalCity.builder().name("capitalcities1").build(),
                CapitalCity.builder().name("capitalcities2").build()
        );

        when(CapitalCityRepository.largestToSmallestCapitalCitiesRegion(region)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/3/"+ region)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.NOT_FOUND.value()));
    }

    /**
     * Test to ensure a HttpStatus of OK with no data in city table for a valid report 3 request
     */
    @Test
    public void largestToSmallestCapitalCitiesRegion_noCitiesInTable() throws Exception {
        String region = "europe";
        List<CapitalCity> capitalCities = List.of();

        when(CapitalCityRepository.largestToSmallestCapitalCitiesRegion(region)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/3/"+ region)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    /**
     * Test to ensure a HttpStatus of OK for a valid report 4 request
     */
    @Test
    public void topNPopulatedCapitalCities() throws Exception {
        int nPopulated = 2;
        List<CapitalCity> capitalCities = List.of(
                CapitalCity.builder().name("capitalcities1").build(),
                CapitalCity.builder().name("capitalcities2").build()
        );

        when(CapitalCityRepository.topNPopulatedCapitalCities(nPopulated)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/4/"+ nPopulated)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(1).getName()));
    }

    /**
     * Test to ensure a HttpStatus of NOT FOUND with an invalid populated report 4 request
     */
    @Test
    public void topNPopulatedCapitalCities_nNotAnInt() throws Exception {
        String nPopulated = "aa";
        List<CapitalCity> capitalCities = List.of(
                CapitalCity.builder().name("capitalcities1").build(),
                CapitalCity.builder().name("capitalcities2").build()
        );

        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/4/"+ nPopulated)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    /**
     * Test to ensure a HttpStatus of OK with no data in countries table for a valid report 4 request
     */
    @Test
    public void topNPopulatedCapitalCities_noCitiesInTable() throws Exception {
        int nPopulated = 2;
        List<CapitalCity> capitalCities = List.of();

        when(CapitalCityRepository.topNPopulatedCapitalCities(nPopulated)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/4/"+ nPopulated)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    /**
     * Test to ensure a HttpStatus of BAD REQUEST with an invalid report 4 request for NumberFormatException
     */
    @Test
    public void topNPopulatedCapitalCities_NumberFormatException() throws Exception {
        int nPopulated = 1;
        when(CapitalCityRepository.topNPopulatedCapitalCities(nPopulated)).thenThrow(new NumberFormatException("error"));
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/4/"+ nPopulated)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    }

    /**
     * Test to ensure a HttpStatus of OK for a valid report 5 request
     */
    @Test
    public void topNPopulatedCapitalCitiesInContinent() throws Exception {
        int nPopulated = 2;
        String continent = "some_continent";
        List<CapitalCity> capitalCities = List.of(
                CapitalCity.builder().name("capitalcities1").build(),
                CapitalCity.builder().name("capitalcities2").build()
        );

        when(CapitalCityRepository.topNPopulatedCapitalCitiesInContinent(nPopulated, continent)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/capitalcities/report/5/"+ nPopulated + "/" + continent)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(1).getName()));
    }

    /**
     * Test to ensure a HttpStatus of NOT FOUND for an invalid populated report 5 request
     */
    @Test
    public void topNPopulatedCapitalCitiesInContinent_nNotAnInt() throws Exception {
        String nPopulated = "aa";
        String continent = "some_continent";
        List<CapitalCity> countries = List.of(
                CapitalCity.builder().name("capitialcities1").build(),
                CapitalCity.builder().name("capitalcities2").build()
        );

        MockHttpServletResponse response = mockMvc.perform(
                        get("/capitalcities/report/5/"+ nPopulated + "/" + continent)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    /**
     * Test to ensure a HttpStatus of BAD REQUEST with an invalid report 5 request for NumberFormatException
     */
    @Test
    public void topNPopulatedCapitalCitiesInContinent_NumberFormatException() throws Exception {
        int nPopulated = 1;
        String continent = "continent";
        when(CapitalCityRepository.topNPopulatedCapitalCitiesInContinent(nPopulated, continent))
                .thenThrow(new NumberFormatException("error"));
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/5/"
                        + nPopulated + "/" + continent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    }

    /**
     * Test to ensure a HttpStatus of OK with no data in city table for a valid report 5 request
     */
    @Test
    public void topNPopulatedCapitalCitiesInContinent_noCitiesInTable() throws Exception {
        int nPopulated = 2;
        String continent = "some_continent";
        List<CapitalCity> capitalCities = List.of();

        when(CapitalCityRepository.topNPopulatedCapitalCitiesInContinent(nPopulated, continent)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/capitalcities/report/5/"+ nPopulated + "/" + continent)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    /**
     * Test to ensure a HttpStatus of OK for a valid report 6 request
     */
    @Test
    public void topNPopulatedCapitalCitiesInRegion() throws Exception {
        int nPopulated = 2;
        String region = "some_region";
        List<CapitalCity> capitalCities = List.of(
                CapitalCity.builder().name("capitalcities1").build(),
                CapitalCity.builder().name("capitialcities2").build()
        );

        when(CapitalCityRepository.topNPopulatedCapitalCitiesInRegion(nPopulated, region)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/capitalcities/report/6/"+ nPopulated + "/" + region)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(capitalCities.get(1).getName()));
    }

    /**
     * Test to ensure a HttpStatus of NOT FOUND for an invalid populated report 6 request
     */
    @Test
    public void topNPopulatedCapitalCitiesInRegion_nNotAnInt() throws Exception {
        String nPopulated = "aa";
        String region = "some_region";
        List<CapitalCity> capitalCities = List.of(
                CapitalCity.builder().name("capitalcities1").build(),
                CapitalCity.builder().name("capitalcities2").build()
        );

        MockHttpServletResponse response = mockMvc.perform(
                        get("/capitalcities/report/6/"+ nPopulated + "/" + region)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    /**
     * Test to ensure a HttpStatus of BAD REQUEST with an invalid report 6 request for NumberFormatException
     */
    @Test
    public void topNPopulatedCapitalCitiesInRegion_NumberFormatException() throws Exception {
        int nPopulated = 1;
        String region = "region";
        when(CapitalCityRepository.topNPopulatedCapitalCitiesInRegion(nPopulated, region))
                .thenThrow(new NumberFormatException("error"));
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/6/"
                        + nPopulated + "/" + region)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    }

    /**
     * Test to ensure a HttpStatus of OK with no data in countries table for a valid report 3 request
     */
    @Test
    public void topNPopulatedCapitialCitiesInRegion_noCitiesInTable() throws Exception {
        int nPopulated = 2;
        String region = "some_region";
        List<CapitalCity> capitalCities = List.of();

        when(CapitalCityRepository.topNPopulatedCapitalCitiesInRegion(nPopulated, region)).thenReturn(capitalCities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/capitalcities/report/6/"+ nPopulated + "/" + region)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }
}
