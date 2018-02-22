package workshop.wiremock.remote.service.impl;

import org.springframework.stereotype.Service;
import workshop.wiremock.remote.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {
    private static final String HI_MESSAGE_TEMPLATE = "Hi %s!";
    private static final String HELLO_MESSAGE_TEMPLATE = "Hello %s!";

    @Override
    public String welcome(String name) {
        if (name.length() % 2 == 0) {
            return String.format(HI_MESSAGE_TEMPLATE, name);
        } else
            return String.format(HELLO_MESSAGE_TEMPLATE, name);
    }
}
