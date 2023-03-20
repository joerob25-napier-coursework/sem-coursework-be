package com.napier.sem.semcoursework.unit.controller;

import com.napier.sem.semcoursework.controller.CountryController;
import com.napier.sem.semcoursework.controller.PopulationController;
import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.Population;
import com.napier.sem.semcoursework.repository.CountryRepository;
import com.napier.sem.semcoursework.repository.PopulationRepository;
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

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Unit tests for the population related reports
 */

@ActiveProfiles("unit")
@RunWith(SpringRunner.class)
@WebMvcTest(PopulationController.class)
public class PopulationControllerTests {

    /**
     * MockMvc to mock http requests
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Stub of the PopulationRepository to mimic database queries
     */
    @MockBean
    private PopulationRepository populationRepository;

    /**
     * Test to ensure a HttpStatus of OK for a valid report 1 request
     */
    @Test
    public void populationOfContinentsLivingInCities() throws Exception {
        List<Population> population = List.of();

        when(populationRepository.populationOfContinentsLivingInCities()).thenReturn(population);
        MockHttpServletResponse response = mockMvc.perform(get("/population/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }
}
