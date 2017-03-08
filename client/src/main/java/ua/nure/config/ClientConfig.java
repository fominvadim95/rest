package ua.nure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("ua.nure.client")
public class ClientConfig {

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }
}
