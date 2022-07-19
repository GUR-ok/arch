package ru.gur.arch.web.personcontroller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gur.arch.web.personcontroller.request.CreateUserRequest;
import ru.gur.arch.web.personcontroller.request.UpdateUserRequest;
import ru.gur.arch.web.personcontroller.response.FindUserResponse;

import javax.validation.Valid;
import java.util.UUID;

public interface PersonController {

    @PostMapping("/users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json")})}
    )
    UUID createUser(@Valid @RequestBody CreateUserRequest request);

    @GetMapping("/users/{uuid}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json")})}
    )
    FindUserResponse findUser(@PathVariable UUID uuid);

    @DeleteMapping("/users/{uuid}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json")})}
    )
    void deleteUser(@PathVariable UUID uuid);

    @PutMapping("/users/{uuid}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json")})}
    )
    void updateUser(@Valid @RequestBody UpdateUserRequest request, @PathVariable UUID uuid);
}
