package com.napier.sem.semcoursework.unit.controller;

import com.napier.sem.semcoursework.controller.CityController;
import com.napier.sem.semcoursework.model.CapitalCity;
import com.napier.sem.semcoursework.model.City;
import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Test class for CityController.
 */

@ActiveProfiles("unit")
@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTests {

    /**
     * MockMvc to mock http requests
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Stub of the CityRepository to mimic database queries
     */
    @MockBean
    private CityRepository cityRepository;

    /**
     * Test method for largestToSmallestCitiesWorld.
     * @throws Exception Exception thrown when the test fails
     */
    @Test
    public void largestToSmallestCitiesWorld() throws Exception {
        List<City> city = List.of(
                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );
        when(cityRepository.largestToSmallestCitiesWorld()).thenReturn(city);
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(city.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(city.get(1).getName()));
    }

    /**
     * Test method for largestToSmallestCitiesContinent.
     * @throws Exception Exception thrown when the test fails
     */
    @Test
    public void largestToSmallestCitiesContinent()  throws Exception {
         String continent="Asia";
         List<City> city = List.of(

                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );
        when(cityRepository.largestToSmallestCitiesContinent(continent)).thenReturn(city);
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/2/Asia")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(city.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(city.get(1).getName()));
    }

    /**
     * Test method for largestToSmallestCitiesRegion.
     * @throws Exception Exception thrown when the test fails
     */
    @Test
    public void largestToSmallestCitiesRegion()  throws Exception {
        String region="Gaza";
        List<City> city = List.of(

                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );
        when(cityRepository.largestToSmallestCitiesRegion(region)).thenReturn(city);
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/3/Gaza")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(city.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(city.get(1).getName()));
    }

    /**
     * Test method for largestToSmallestCitiesCountry.
     * @throws Exception Exception thrown when the test fails
     */
    @Test
    public void largestToSmallestCitiesCountry()  throws Exception {
        String country="China";
        List<City> city = List.of(

                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );
        when(cityRepository.largestToSmallestCitiesCountry(country)).thenReturn(city);
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/4/China")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(city.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(city.get(1).getName()));
    }

    /**
     * Test method for largestToSmallestCitiesDistrict.
     * @throws Exception Exception thrown when the test fails
     */
    @Test
    public void largestToSmallestCitiesDistrict()  throws Exception {
        String district="Kabol";
        List<City> city = List.of(

                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );
        when(cityRepository.largestToSmallestCitiesDistrict(district)).thenReturn(city);
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/5/Kabol")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(city.get(0).getName()));
        assertThat(response.getContentAsString(), containsString(city.get(1).getName()));
    }

    @Test
    public void topNCitiesInContLargestToSmallest()  throws Exception {
        int nPopulated = 2;
        List<City> cities = List.of(
                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );

        when(cityRepository.topNContinent(nPopulated, "Asia")).thenReturn(cities);
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/6/5/Asia")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure a HttpStatus of NOT FOUND for an invalid populated report 6 request
     */
    @Test
    public void topNCitiesInContinent_nNotAnInt() throws Exception {
        String nPopulated = "aa";
        String continent = "some_continent";
        List<City> cities = List.of(
                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );

        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/6/"+ nPopulated + "/" + continent)
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
    public void topNCitiesInContinent_NumberFormatException() throws Exception {
        int nPopulated = 1;
        String district = "some_district";
        when(cityRepository.topNContinent(nPopulated, district))
                .thenThrow(new NumberFormatException("error"));
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/6/"
                        + nPopulated + "/" + district)
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
    public void topNCitiesInContinent_noCitiesInTable() throws Exception {
        int nPopulated = 2;
        String continent = "some_continent";
        List<City> cities = List.of();

        when(cityRepository.topNContinent(nPopulated, continent)).thenReturn(cities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/6/"+ nPopulated + "/" + continent)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void topNCitiesInRegion() throws Exception {
        int nPopulated = 2;
        List<City> cities = List.of(
                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );

        when(cityRepository.topNCitiesRegion(nPopulated, "Fife")).thenReturn(cities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/7/3/Fife")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure a HttpStatus of NOT FOUND for an invalid populated report 6 request
     */
    @Test
    public void topNCitiesInRegion_nNotAnInt() throws Exception {
        String nPopulated = "aa";
        String region = "some_region";
        List<City> cities = List.of(
                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );

        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/7/"+ nPopulated + "/" + region)
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
    public void topNCitiesInRegion_NumberFormatException() throws Exception {
        int nPopulated = 1;
        String region = "region";
        when(cityRepository.topNCitiesRegion(nPopulated, region))
                .thenThrow(new NumberFormatException("error"));
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/7/"
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
    public void topNCitiesInRegion_noCitiesInTable() throws Exception {
        int nPopulated = 2;
        String region = "some_region";
        List<City> cities = List.of();

        when(cityRepository.topNCitiesRegion(nPopulated, region)).thenReturn(cities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/7/"+ nPopulated + "/" + region)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void topNCitiesInDistrict() throws Exception {
        int nPopulated = 2;
        String district = "some_district";
        List<City> cities = List.of(
                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );

        when(cityRepository.topNCitiesDistrict(nPopulated, "some_district")).thenReturn(cities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/8/"+ nPopulated + "/" + district)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure a HttpStatus of NOT FOUND for an invalid populated report 6 request
     */
    @Test
    public void topNCitiesInDistrict_nNotAnInt() throws Exception {
        String nPopulated = "aa";
        String district = "some_district";
        List<City> cities = List.of(
                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );

        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/8/"+ nPopulated + "/" + district)
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
    public void topNCitiesInDistrict_NumberFormatException() throws Exception {
        int nPopulated = 1;
        String district = "some_district";
        when(cityRepository.topNCitiesDistrict(nPopulated, district))
                .thenThrow(new NumberFormatException("error"));
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/8/"
                        + nPopulated + "/" + district)
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
    public void topNCitiesInDistrict_noCitiesInTable() throws Exception {
        int nPopulated = 2;
        String district = "some_district";
        List<City> cities = List.of();

        when(cityRepository.topNCitiesRegion(nPopulated, district)).thenReturn(cities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/8/"+ nPopulated + "/" + district)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

    @Test
    public void topNCitiesInCountry() throws Exception {
        int nPopulated = 2;
        String country = "some_country";
        List<City> cities = List.of(
                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );

        when(cityRepository.topNCitiesCountry(nPopulated, "some_contract")).thenReturn(cities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/9/"+ nPopulated + "/" + country)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure a HttpStatus of NOT FOUND for an invalid populated report 6 request
     */
    @Test
    public void topNCitiesInCountry_nNotAnInt() throws Exception {
        String nPopulated = "aa";
        String country = "some_country";
        List<City> cities = List.of(
                City.builder().name("city1").build(),
                City.builder().name("city2").build()
        );

        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/9/"+ nPopulated + "/" + country)
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
    public void topNCitiesInCountry_NumberFormatException() throws Exception {
        int nPopulated = 1;
        String country = "some_country";
        when(cityRepository.topNCitiesCountry(nPopulated, country))
                .thenThrow(new NumberFormatException("error"));
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/9/"
                        + nPopulated + "/" + country)
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
    public void topNCitiesInCountry_noCitiesInTable() throws Exception {
        int nPopulated = 2;
        String country = "some_country";
        List<City> cities = List.of();

        when(cityRepository.topNCitiesCountry(nPopulated, country)).thenReturn(cities);
        MockHttpServletResponse response = mockMvc.perform(
                        get("/cities/report/8/"+ nPopulated + "/" + country)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }

}