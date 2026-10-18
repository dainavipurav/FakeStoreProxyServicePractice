package com.learning.springboot.proxyServiceDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient.Builder getRestClientBuilder(){
        return RestClient.builder();
    }

    @Bean
    public RestClient getApiClient(RestClient.Builder builder){
        return builder.build();
    }

}
