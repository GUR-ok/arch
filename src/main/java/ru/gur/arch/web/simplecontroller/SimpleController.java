package ru.gur.arch.web.simplecontroller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gur.arch.web.simplecontroller.request.SimpleRequest;
import ru.gur.arch.web.simplecontroller.response.SimpleResponse;

import javax.validation.Valid;

public interface SimpleController {

    @PostMapping("/action")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json")})}
    )
    SimpleResponse controllerEndpoint(@Valid @RequestBody SimpleRequest request);
}
