package com.example.demorest.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import brave.Tracer;

public class SleuthCommonsRequestLoggingFilter extends CommonsRequestLoggingFilter {

    @Autowired
    private Tracer tracer;

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        super.beforeRequest(request, message);
        System.out.println("message: " + message);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        super.afterRequest(request, message);
        // this.tracer.currentSpan().tag("request info", message);
        // this.logger.info(message);
    }

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return true;
    }
}
