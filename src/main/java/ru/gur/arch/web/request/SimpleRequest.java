package ru.gur.arch.web.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class SimpleRequest {

    @NotBlank(message = "input must not be blank")
    private final String input;
}
