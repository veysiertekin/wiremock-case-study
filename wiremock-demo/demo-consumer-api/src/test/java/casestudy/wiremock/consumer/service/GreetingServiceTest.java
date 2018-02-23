package casestudy.wiremock.consumer.service;

import casestudy.wiremock.consumer.delegate.remote.RemoteGreetingClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ActiveProfiles("default")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @MockBean
    private RemoteGreetingClient remoteGreetingClient;

    @Test
    public void should_success_with_a_valid_name() {
        String name = "name";
        final String expectedResult = "Greetings name!";

        when(remoteGreetingClient.sayHi(name)).thenReturn(expectedResult);

        String result = greetingService.sayHi(name);
        assertThat(result)
                .isEqualTo(expectedResult);

        verify(remoteGreetingClient, times(1)).sayHi(name);
        verifyNoMoreInteractions(remoteGreetingClient);
    }
}