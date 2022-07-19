package ru.gur.arch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gur.arch.entity.Person;
import ru.gur.arch.exception.PersonNotFoundException;
import ru.gur.arch.persistence.PersonRepository;
import ru.gur.arch.service.data.PersonData;
import ru.gur.arch.service.immutable.ImmutableCreatePersonRequest;
import ru.gur.arch.service.immutable.ImmutableUpdatePersonRequest;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public UUID createPerson(final ImmutableCreatePersonRequest request) {
        final Person person = new Person();
        person.setName(request.getName());

        return personRepository.save(person).getId();
    }

    @Override
    public PersonData findPerson(final UUID uuid) {
        final Person person = personRepository.findById(uuid).orElseThrow(PersonNotFoundException::new);

        return PersonData.builder()
                .name(person.getName())
                .build();
    }

    @Override
    public void deletePerson(final UUID uuid) {
        personRepository.deleteById(uuid);
    }

    @Override
    public void updatePerson(final ImmutableUpdatePersonRequest request, final UUID uuid) {
        final Person person = personRepository.findById(uuid).orElseThrow(PersonNotFoundException::new);
        person.setName(request.getName());

        personRepository.save(person);
    }
}
