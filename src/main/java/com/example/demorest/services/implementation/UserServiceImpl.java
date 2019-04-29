package com.example.demorest.services.implementation;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demorest.exceptions.ForbiddenException;
import com.example.demorest.model.ApplicationUser;
import com.example.demorest.repository.ApplicationUserRepository;
import com.example.demorest.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveUser(ApplicationUser user) {

        LOGGER.info("Saving user: " + user.getUsername());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ApplicationUser>> violations = validator.validate(user);

        if (violations.stream().count() > 0) {
            for (ConstraintViolation<ApplicationUser> violation : violations) {
                LOGGER.error(violation.getMessage());
            }

            throw new ForbiddenException(violations.stream().map(v -> v.getMessage()).collect(Collectors.joining(", ")));
        }

        if (this.applicationUserRepository.findByUsername(user.getUsername()) != null) {
            LOGGER.info("UserName already used: " + user.getUsername());
            throw new ForbiddenException("UserName already in use");
        }

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        this.applicationUserRepository.save(user);
        LOGGER.info("Saved user: " + user.getUsername());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = this.applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }

    @Override
    public List<ApplicationUser> getAll() {
        return this.applicationUserRepository.findAll();
    }
}
