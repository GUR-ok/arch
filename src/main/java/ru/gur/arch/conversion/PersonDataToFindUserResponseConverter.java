package ru.gur.arch.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gur.arch.service.data.PersonData;
import ru.gur.arch.web.personcontroller.response.FindUserResponse;
import ru.gur.arch.web.personcontroller.response.PersonDTO;

@Component
public class PersonDataToFindUserResponseConverter
    implements Converter<PersonData, FindUserResponse> {

  @Override
  public FindUserResponse convert(final PersonData source) {
    return FindUserResponse.builder()
        .user(convertUser(source))
        .build();
  }

  private PersonDTO convertUser(PersonData personData) {
    return PersonDTO.builder()
        .name(personData.getName())
        .build();
  }
}
