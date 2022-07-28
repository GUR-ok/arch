package ru.gur.arch.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gur.arch.service.immutable.ImmutableCreatePersonRequest;
import ru.gur.arch.web.personcontroller.request.CreateUserRequest;

@Component
public class CreateUserRequestToImmutableCreatePersonRequestConverter
    implements Converter<CreateUserRequest, ImmutableCreatePersonRequest> {

  @Override
  public ImmutableCreatePersonRequest convert(final CreateUserRequest source) {
    return ImmutableCreatePersonRequest.builder()
            .firstName(source.getFirstName())
            .lastName(source.getLastName())
            .email(source.getEmail())
            .phone(source.getPhone())
            .build();
  }
}
