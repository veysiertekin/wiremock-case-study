package casestudy.wiremock.consumer.delegate.remote.regular;

import casestudy.wiremock.consumer.delegate.remote.RemoteGreetingClient;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("default")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class RemoteGreetingClientTest {
    @ClassRule
    public static final WireMockClassRule wireMockClassRule = new WireMockClassRule(options()
            .port(9091)
            .extensions(new ResponseTemplateTransformer(true)));

    @Autowired
    private RemoteGreetingClient remoteGreetingClient;

    @Test
    public void test() {
        final String name = "name";

        wireMockClassRule.stubFor(get(urlPathMatching("/hi/" + name))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/plain;charset=UTF-8")
                        .withBody("Greetings {{request.path.[1]}}!")));

        String result = remoteGreetingClient.sayHi(name);

        assertThat(result)
                .isEqualTo("Greetings " + name + "!");
    }
}