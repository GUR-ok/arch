package ru.gur.arch.web.simplecontroller;

import org.springframework.web.bind.annotation.RestController;
import ru.gur.arch.web.simplecontroller.request.SimpleRequest;
import ru.gur.arch.web.simplecontroller.response.SimpleResponse;

@RestController
public class SimpleControllerImpl implements SimpleController {

    @Override
    public SimpleResponse controllerEndpoint(final SimpleRequest request) {
    return SimpleResponse.builder()
            .output(request.getInput().toUpperCase())
            .build();
    }
}
