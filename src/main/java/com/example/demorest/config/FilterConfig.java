package com.example.demorest.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demorest.filter.LoggingFilter;

@Configuration
public class FilterConfig {

    // @Bean
    // RestTemplate getRestTemplate() {
    // return new RestTemplate();
    // }

    // @Bean
    // public Filter logFilter() {
    //
    // SleuthCommonsRequestLoggingFilter filter = new SleuthCommonsRequestLoggingFilter();
    //
    // filter.setIncludeQueryString(true);
    // filter.setIncludePayload(true);
    // filter.setMaxPayloadLength(5120);
    // filter.setIncludeHeaders(true);
    // return filter;
    // }

    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LoggingFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
}
