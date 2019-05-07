package com.example.demorest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demorest.model.ApplicationUser;
import com.example.demorest.services.UserService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {

        this.userService.saveUser(user);
    }

    @GetMapping("/")
    public List<ApplicationUser> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/all")
    public List<ApplicationUser> getAllRestCall(
            @ApiParam(value = "Authorization", required = false, hidden = true) @RequestHeader("Authorization") String token) {

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        var entity = new HttpEntity<>(null, headers);

        var restTemplate = new RestTemplate();
        var response = restTemplate.exchange("http://localhost:8080/users/", HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<ApplicationUser>>() {
                });

        return response.getBody();
    }
}