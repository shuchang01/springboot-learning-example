package org.spring.springboot.config;

import org.spring.springboot.filter.RequestCostFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * Created by shangpan on 2017/5/27.
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean costFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new RequestCostFilter());
        registration.addUrlPatterns("/*");
        registration.setName("costFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }
}
