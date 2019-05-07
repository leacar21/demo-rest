package com.example.demorest.countries;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demorest.exceptions.ForbiddenException;
import com.example.demorest.model.Country;
import com.example.demorest.services.CountryService;
import com.example.demorest.services.implementation.CountryServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryServiceIntegrationTest {

    @TestConfiguration
    static class CountryServiceImplTestContextConfiguration {

        @Bean
        public CountryService countryService() {
            return new CountryServiceImpl();
        }
    }

    @Autowired
    private CountryService countryService;

    @Test
    public void createCountry_success() {
        // given
        var c1 = new Country("Country1", "C1", 25000);

        this.countryService.createCountry(c1);
        Assert.assertTrue(true);
    }

    @Test(expected = ForbiddenException.class)
    public void createCountry_duplicate() {
        // given
        var c2 = new Country("Country2", "C2", 25000);

        this.countryService.createCountry(c2);
        this.countryService.createCountry(c2);
    }

    @Test
    public void getCountry_success() {
        // given
        var c3 = new Country("Country3", "C3", 25000);

        this.countryService.createCountry(c3);

        // when
        var country = this.countryService.getCountry(c3.getCode());

        // then
        Assert.assertNotNull(country);
        Assert.assertTrue(c3.getName().equals(country.getName()));
    }

    @Test
    public void getCountries_success() {
        // given
        var c4 = new Country("Country4", "C4", 25000);

        this.countryService.createCountry(c4);

        // when
        var countries = this.countryService.getCountries();

        // then
        Assert.assertTrue(countries.size() > 0);
    }

}
