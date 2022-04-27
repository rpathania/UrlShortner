package com.zageno.urlshortner.interceptor;

import com.zageno.urlshortner.service.ShortLinkServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RequestUrlInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestUrlInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("Imntercepting request"+request.getInputStream().toString());
     /*   LOGGER.info("[preHandle][" + request + "]" + "[" + request.getMethod()
                + "]" + request.getReader().lines().reduce("",String::concat));
*/
      //  LOGGER.info(extractPostRequestBody(request));
       // return HandlerInterceptor.super.preHandle(request, response, handler);
        return  true;
    }

    static String extractPostRequestBody(HttpServletRequest request) throws IOException {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            Scanner s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        }
        return "";
    }
}
