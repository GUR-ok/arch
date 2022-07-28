package ru.gur.arch.web.personcontroller.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PersonDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private LocalDateTime created;
}
