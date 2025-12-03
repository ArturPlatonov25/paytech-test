package pay.tech.test.config;


import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Value("${payment.api.token}")
    private String bearerToken;

    @Bean
    public RequestInterceptor authInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + bearerToken);
            requestTemplate.header("Content-Type", "application/json");
        };
    }
}
