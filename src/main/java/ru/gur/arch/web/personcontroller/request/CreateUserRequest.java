package ru.gur.arch.web.personcontroller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserRequest {

    private String name;
}