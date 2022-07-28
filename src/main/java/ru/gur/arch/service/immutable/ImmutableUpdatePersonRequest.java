package ru.gur.arch.service.immutable;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ImmutableUpdatePersonRequest {

    String firstName;

    String lastName;

    String email;

    String phone;
}
