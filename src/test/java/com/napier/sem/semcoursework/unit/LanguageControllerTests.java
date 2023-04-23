package com.napier.sem.semcoursework.unit;

import com.napier.sem.semcoursework.controller.LanguageController;
import com.napier.sem.semcoursework.model.Language;
import com.napier.sem.semcoursework.repository.LanguageRepository;
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
@WebMvcTest(LanguageController.class)
public class LanguageControllerTests {

    /**
     * MockMvc to mock http requests
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Stub of the LanguageRepository to mimic database queries
     */
    @MockBean
    private LanguageRepository LanguageRepository;

    /**
     * Test to ensure a HttpStatus of OK for a valid report 1 request
     */
    @Test
    public void getAllLanguagesOrderedLargestToSmallest() throws Exception {
        List<Language> language = List.of(
                Language.builder().language("language1").build()
        );

        when(LanguageRepository.languagesOrderedLargestToSmallest()).thenReturn(language);
        MockHttpServletResponse response = mockMvc.perform(get("/language/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), containsString(language.get(0).getLanguage()));
    }

    /**
     * Test to ensure a HttpStatus of OK with no data in the countries table for a valid report 1 request
     */
    @Test
    public void allLanguagesOrderedLargestToSmallest_noLanguagesInTable() throws Exception {
        List<Language> language = List.of();

        when(LanguageRepository.languagesOrderedLargestToSmallest()).thenReturn(language);
        MockHttpServletResponse response = mockMvc.perform(get("/language/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();
        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentLength() == 0, is(true));
    }
}
