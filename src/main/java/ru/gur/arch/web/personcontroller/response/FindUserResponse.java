package ru.gur.arch.web.personcontroller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindUserResponse {

    private PersonDTO user;
}
