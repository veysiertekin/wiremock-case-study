package casestudy.wiremock.consumer.service.spring;

import casestudy.wiremock.consumer.delegate.remote.RemoteGreetingClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Spring Cloud Contract
 */

@ActiveProfiles("default")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureWireMock(port = 9091)
public class GreetingServiceTest {

    @Autowired
    private RemoteGreetingClient remoteGreetingClient;

    @Test
    public void test() {
        final String name = "name";

        stubFor(get(urlPathMatching("/hi/" + name))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/plain;charset=UTF-8")
                        .withBody("Greetings {{request.path.[1]}}!")));

        String result = remoteGreetingClient.sayHi(name);

        assertThat(result)
                .isEqualTo("Greetings " + name + "!");
    }
}
