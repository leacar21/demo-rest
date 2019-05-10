package com.example.demorest.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // ContentCachingRequestWrapper requestCacheWrapperObject = new ContentCachingRequestWrapper(request);
        // requestCacheWrapperObject.getParameterMap();

        // ContentCachingRequestWrapper requestCacheWrapperObject = new ContentCachingRequestWrapper(request);
        // requestCacheWrapperObject.getParameterMap(); // needed for caching!!
        //
        // BufferedReader reader = requestCacheWrapperObject.getReader();
        // String body = reader.readLine();

        // ByteSource.wrap((requestCacheWrapperObject).getContentAsByteArray()).asCharSource(StandardCharsets.UTF_8).read(); //
        // Ple

        // String body = null;
        // try {
        // body = IOUtils.toString(requestCacheWrapperObject.getInputStream(), UTF_8);
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // byte[] bodyBytes = requestCacheWrapperObject.getContentAsByteArray();
        // String body = new String(bodyBytes);

        // System.out.println("==========");
        // System.out.println("ContentLength: " + requestCacheWrapperObject.getContentLength());
        // System.out.println("ContentType: " + requestCacheWrapperObject.getContentType());
        // System.out.println("ContextPath: " + requestCacheWrapperObject.getContextPath());
        // System.out.println("body" + body);
        System.out.println("==========");

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //
    }
}