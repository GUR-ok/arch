package ru.gur.arch.service;

import ru.gur.arch.service.data.PersonData;
import ru.gur.arch.service.immutable.ImmutableCreatePersonRequest;
import ru.gur.arch.service.immutable.ImmutableUpdatePersonRequest;

import java.util.UUID;

public interface PersonService {

    UUID createPerson(ImmutableCreatePersonRequest request);

    PersonData findPerson(UUID uuid);

    void deletePerson(UUID uuid);

    void updatePerson(ImmutableUpdatePersonRequest request, UUID uuid);
}
