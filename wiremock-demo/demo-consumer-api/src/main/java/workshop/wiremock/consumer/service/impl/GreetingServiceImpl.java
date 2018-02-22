package workshop.wiremock.consumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.wiremock.consumer.delegate.remote.RemoteGreetingClient;
import workshop.wiremock.consumer.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {
    private final RemoteGreetingClient remoteGreetingClient;

    @Autowired
    public GreetingServiceImpl(RemoteGreetingClient remoteGreetingClient) {
        this.remoteGreetingClient = remoteGreetingClient;
    }

    @Override
    public String welcome(String name) {
        return remoteGreetingClient.welcome(name);
    }
}
