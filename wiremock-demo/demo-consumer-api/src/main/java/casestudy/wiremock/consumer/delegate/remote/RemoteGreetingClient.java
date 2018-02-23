package casestudy.wiremock.consumer.delegate.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "demo-remote-api")
public interface RemoteGreetingClient {
    @GetMapping("/hi/{name}")
    String sayHi(@PathVariable("name") String name);
}
