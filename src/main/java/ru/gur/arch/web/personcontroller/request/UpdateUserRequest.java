package ru.gur.arch.web.personcontroller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@Builder
public class UpdateUserRequest {

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String phone;
}
