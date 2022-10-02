package com.assignment.Defense.of.the.Ancients2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * This is BeanConfiguration class.
 * @author karan
 */
@Configuration
public class BeanConfiguration {

    /**
     * This is getRestTemplate() method for creation of rest template bean.
     * @return object of rest template.
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
