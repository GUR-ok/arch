package ru.gur.arch.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gur.arch.service.immutable.ImmutableUpdatePersonRequest;
import ru.gur.arch.web.personcontroller.request.UpdateUserRequest;

@Component
public class UpdateUserRequestToImmutableUpdatePersonRequestConverter
    implements Converter<UpdateUserRequest, ImmutableUpdatePersonRequest> {

  @Override
  public ImmutableUpdatePersonRequest convert(final UpdateUserRequest source) {
    return ImmutableUpdatePersonRequest.builder()
            .firstName(source.getFirstName())
            .lastName(source.getLastName())
            .email(source.getEmail())
            .phone(source.getPhone())
            .build();
  }
}
