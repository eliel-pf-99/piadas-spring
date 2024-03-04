package api.piadas.piadas.config;

import api.piadas.piadas.services.PiadasService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class config {
    @Bean
    public PiadasService piadasService() throws IOException {
        return new PiadasService();
    }
}
