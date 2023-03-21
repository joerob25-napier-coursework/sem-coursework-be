package com.napier.sem.semcoursework.controller;

import com.napier.sem.semcoursework.model.City;
import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.repository.CityRepository;
import com.napier.sem.semcoursework.repository.CountryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.plaf.synth.Region;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
        assertThat(response.getContentAsString(), containsString(city.get(1).getName()));}








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
        assertThat(response.getContentAsString(), containsString(city.get(1).getName()));}





}