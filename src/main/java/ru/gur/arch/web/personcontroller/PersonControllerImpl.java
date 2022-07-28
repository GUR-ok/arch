package ru.gur.arch.web.personcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RestController;
import ru.gur.arch.service.PersonService;
import ru.gur.arch.service.immutable.ImmutableCreatePersonRequest;
import ru.gur.arch.service.immutable.ImmutableUpdatePersonRequest;
import ru.gur.arch.web.personcontroller.request.CreateUserRequest;
import ru.gur.arch.web.personcontroller.request.UpdateUserRequest;
import ru.gur.arch.web.personcontroller.response.FindUserResponse;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PersonControllerImpl implements PersonController {

  private final PersonService personService;
  private final ConversionService conversionService;

  @Override
  public UUID createUser(final CreateUserRequest request) {
    return personService.createPerson(
        conversionService.convert(request, ImmutableCreatePersonRequest.class));
  }

  @Override
  public FindUserResponse findUser(final UUID uuid) {
    return conversionService.convert(personService.findPerson(uuid), FindUserResponse.class);
  }

  @Override
  public void deleteUser(final UUID uuid) {
    personService.deletePerson(uuid);
  }

  @Override
  public void updateUser(final UpdateUserRequest request, final UUID uuid) {
    personService.updatePerson(
        conversionService.convert(request, ImmutableUpdatePersonRequest.class), uuid);
  }
}
