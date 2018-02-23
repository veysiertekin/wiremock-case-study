package casestudy.wiremock.consumer.delegate.remote.spring;

import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.contract.wiremock.WireMockConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class WiremockConfiguration {
    @Bean
    WireMockConfigurationCustomizer optionsCustomizer() {
        return wireMockConfiguration -> wireMockConfiguration.extensions(new ResponseTemplateTransformer(true));
    }
}
