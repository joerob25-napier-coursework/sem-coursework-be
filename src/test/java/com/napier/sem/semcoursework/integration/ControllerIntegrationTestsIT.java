package com.napier.sem.semcoursework.integration;

import com.napier.sem.semcoursework.ITTemplate;
import com.napier.sem.semcoursework.model.utils.CompositeKey;
import com.napier.sem.semcoursework.model.Country;
import com.napier.sem.semcoursework.model.utils.CountryLanguage;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Integration tests for connectivity with db
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ControllerIntegrationTestsIT extends ITTemplate {

    /**
     * MockMvc to mock http requests
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test to ensure a new country can be inserted into the country table and assert that the value is correct
     */
    @Test
    public void countryDatabaseInsertTest() {
        Country country = Country.builder()
                .code("abc")
                .name("name")
                .continent("Asia")
                .region("region")
                .surfaceArea(2.00)
                .indepYear(1)
                .population(100)
                .lifeExpectancy(2.0)
                .gnp(5.1)
                .localName("local_name")
                .governmentForm("A")
                .headOfState("B")
                .capital(4)
                .code2("I")
                .build();
            Country savedCountry = countryRepository.save(country);
            assertThat(savedCountry, is(country));
    }

    /**
     * Test to ensure a new country language can be inserted into the country language table and assert that the value is correct
     */
    @Test
    public void countryLanguageDatabaseInsertTest() {
        CountryLanguage cl = CountryLanguage.builder()
                .compositeKey(CompositeKey.builder().countryCode("PAK").language("idfj").build())
                .isOfficial(true)
                .percentage(20.1)
                .build();

        CountryLanguage saveCl = countryLanguageRepository.save(cl);
        assertThat(saveCl, is(cl));
    }

    /**
     * Test to ensure that a valid request to the country report 1 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void allCountriesOrderedLargestToSmallest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid request to the country report 2 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void allCountriesInContinentOrderedLargestToSmallest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/2/test")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid request to the country report 3 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void allCountriesInRegionOrderedLargestToSmallest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/3/test")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid request to the country report 4 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void topNPopulatedCountries() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/4/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid request to the country report 5 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void topNPopulatedCountriesInContinent() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/5/3/Europe")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid request to the country report 6 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void topNPopulatedCountriesInRegion() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/countries/report/6/3/region")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Tests the functionality of retrieving all cities in the world, sorted by population from largest to smallest.
     * @throws Exception if an error occurs while performing the HTTP request.
     */
    @Test
    public void citiesInTheWorldLargestToSmallest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Tests the functionality of retrieving cities in a continent, sorted by population from largest to smallest.
     * @throws Exception if an error occurs while performing the HTTP request.
     */
    @Test
    public void citiesInContinentLargestToSmallest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/2/Europe")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Tests the functionality of retrieving cities in a region, sorted by population from largest to smallest.
     * @throws Exception if an error occurs while performing the HTTP request.
     */
    @Test
    public void citiesInRegionLargestToSmallest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/3/Yorkshire")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Tests the functionality of retrieving cities in a country, sorted by population from largest to smallest.
     * @throws Exception if an error occurs while performing the HTTP request.
     */
    @Test
    public void citiesInCountryLargestToSmallest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/4/France")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Tests the functionality of retrieving cities in a district, sorted by population from largest to smallest.
     * @throws Exception if an error occurs while performing the HTTP request.
     */
    @Test
    public void citiesInDistrictLargestToSmallest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/cities/report/5/ksd")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid response from the population report 1 and returns a status of OK
     */
    @Test
    public void populationOfContinentsLivingInCities() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/population/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid response from the population report 2 and returns a status of OK
     */
    @Test
    public void populationOfRegionLivingInCities() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/population/report/2")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid response from the population report 3 and returns a status of OK
     */
    @Test
    public void populationOfCountryLivingInCities() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/population/report/3")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid request to the language report 1 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void languagesOrderedLargestToSmallest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/language/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();
        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid request to the capital city report 1 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void largestToSmallestCapitalCitiesWorld() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid request to the capital city report 2 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void largestToSmallestCapitalCitiesRegion() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/2/test")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));

    }

    /**
     * Test to ensure that a valid request to the country report 4 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void topNPopulatedCapitalCities() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/4/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid request to the country report 5 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void topNPopulatedCapitalCitiesInContinent() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/5/3/Europe")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid request to the country report 6 endpoint without a repository stub returns a status
     * of OK
     */
    @Test
    public void topNPopulatedCapitalCitiesInRegion() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/capitalcities/report/6/3/region")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid response from the additional population report: world and returns a status of OK
     */
    @Test
    public void AdditionalCountryLevelPopulationRepository() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/world")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid response from the additional population report: continent and returns a status of OK
     */
    @Test
    public void AdditionalContinentLevelPopulationRepository() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/continent/Asia")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid response from the additional population report: region and returns a status of OK
     */
    @Test
    public void AdditionalRegionLevelPopulationRepository() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/region/abc")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid response from the additional population report: district and returns a status of OK
     */
    @Test
    public void AdditionalDistrictLevelPopulationRepository() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/district/abc")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }

    /**
     * Test to ensure that a valid response from the additional population report: city and returns a status of OK
     */
    @Test
    public void AdditionalCityLevelPopulationRepository() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/population/population/city/potato")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus(), Is.is(HttpStatus.OK.value()));
    }
}
