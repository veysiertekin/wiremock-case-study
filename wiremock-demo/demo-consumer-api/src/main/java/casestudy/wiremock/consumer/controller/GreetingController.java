package casestudy.wiremock.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import casestudy.wiremock.consumer.service.GreetingService;

@RestController
public class GreetingController {
    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hi/{name}")
    public String sayHi(@PathVariable("name") String name) {
        return greetingService.sayHi(name);
    }
}
