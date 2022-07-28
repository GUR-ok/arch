package ru.gur.arch.service.immutable;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ImmutableCreatePersonRequest {

    String firstName;

    String lastName;

    String email;

    String phone;
}
