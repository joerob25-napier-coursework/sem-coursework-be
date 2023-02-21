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
        // given
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
}
