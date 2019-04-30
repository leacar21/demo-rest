package com.example.demorest.users;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.TestContextManager;

import com.example.demorest.exceptions.ForbiddenException;
import com.example.demorest.model.ApplicationUser;
import com.example.demorest.services.UserService;
import com.example.demorest.services.implementation.UserServiceImpl;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
// @RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceIntegrationTest {

    private TestContextManager testContextManager;

    @Before
    public void setUpContext() throws Exception {
        // this is where the magic happens, we actually do "by hand" what the spring runner would do for us,
        // read the JavaDoc for the class bellow to know exactly what it does, the method names are quite accurate though
        this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
    }

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void createUser_success() {
        // given
        ApplicationUser u1 = new ApplicationUser("user1", "user1", 40);

        this.userService.saveUser(u1);
        Assert.assertTrue(true);
    }

    @Test(expected = ForbiddenException.class)
    public void createUser_duplicate() {
        ApplicationUser u2 = new ApplicationUser("user2", "user2", 40);

        this.userService.saveUser(u2);
        this.userService.saveUser(u2);
    }

    @Test(expected = ForbiddenException.class)
    @Parameters({ " , test, 20", "test, , 20", "test, test, -10" })
    public void createUser_invalid(String name, String password, int age) {
        ApplicationUser u2 = new ApplicationUser(name, password, age);

        this.userService.saveUser(u2);
    }

    @Test
    public void getUsers_success() {

        ApplicationUser u3 = new ApplicationUser("user3", "user3", 40);

        this.userService.saveUser(u3);

        List<ApplicationUser> users = this.userService.getAll();

        Assert.assertTrue(users.size() > 0);
    }

    @Test
    public void getUserDetails_success() {

        ApplicationUser u4 = new ApplicationUser("user4", "user4", 40);

        this.userService.saveUser(u4);

        UserDetails user = this.userService.loadUserByUsername("user4");

        Assert.assertTrue(user != null);
        Assert.assertEquals(user.getUsername(), u4.getUsername());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void getUserDetails_fails() {
        this.userService.loadUserByUsername("userNotCreated");
    }

}