package casestudy.wiremock.remote.service.impl;

import casestudy.wiremock.remote.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    private static final String HI_MESSAGE_TEMPLATE = "Hi %s!";
    private static final String HELLO_MESSAGE_TEMPLATE = "Hello %s!";

    @Override
    public String sayHi(String name) {
        return String.format(findMatchedTemplate(name.length()), name);
    }

    private String findMatchedTemplate(int length) {
        return length % 2 == 0 ? HI_MESSAGE_TEMPLATE : HELLO_MESSAGE_TEMPLATE;
    }
}
