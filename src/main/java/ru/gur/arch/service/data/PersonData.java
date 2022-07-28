package ru.gur.arch.service.data;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class PersonData {

    String firstName;

    String lastName;

    String email;

    String phone;

    LocalDateTime createdDate;
}
