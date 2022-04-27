package com.zageno.urlshortner.config;

import com.zageno.urlshortner.interceptor.RequestUrlInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Configuration/registry class for interceptors.
 * @author Rishi Pathania
 * @version 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(final InterceptorRegistry registry){
        registry.addInterceptor(new RequestUrlInterceptor());
    }
}

