package ru.gur.arch.web;

import org.springframework.web.bind.annotation.RestController;
import ru.gur.arch.web.request.SimpleRequest;
import ru.gur.arch.web.response.SimpleResponse;

@RestController
public class SimpleControllerImpl implements SimpleController {

    @Override
    public SimpleResponse controllerEndpoint(final SimpleRequest request) {
    return SimpleResponse.builder()
            .output(request.getInput().toUpperCase())
            .build();
    }
}
