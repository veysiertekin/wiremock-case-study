package casestudy.wiremock.remote.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("default")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void should_success_with_even_sized_name() {
        String name = "even";
        final String expectedResult = "Hi even!";

        String result = greetingService.sayHi(name);
        assertThat(result)
                .isEqualTo(expectedResult);
    }

    @Test
    public void should_success_with_odd_sized_name() {
        String name = "odd";
        final String expectedResult = "Hello odd!";

        String result = greetingService.sayHi(name);
        assertThat(result)
                .isEqualTo(expectedResult);
    }
}