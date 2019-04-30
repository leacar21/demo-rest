package com.example.demorest.countries;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demorest.model.Country;
import com.example.demorest.repository.CountryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given

        int aaa = 3;

        Country countryUY = new Country("Uruguay", "UY", 25000);
        this.entityManager.persist(countryUY);
        this.entityManager.flush();

        // when
        List<Country> listString = this.countryRepository.findByCode(countryUY.getCode());
        Country result = listString.stream().findFirst().orElse(null);

        // then
        Assert.assertTrue(countryUY.getName().equals(result.getName()));
    }

}
