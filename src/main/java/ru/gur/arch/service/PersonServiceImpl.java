package ru.gur.arch.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setEmail(request.getEmail());
        person.setPhone(request.getPhone());

        return personRepository.save(person).getId();
    }

    @Override
    public PersonData findPerson(final UUID uuid) {
        final Person person = personRepository.findById(uuid).orElseThrow(PersonNotFoundException::new);

        return PersonData.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .phone(person.getPhone())
                .createdDate(person.getCreated())
                .firstName(person.getFirstName())
                .build();
    }

    @Override
    public void deletePerson(final UUID uuid) {
        personRepository.deleteById(uuid);
    }

    @Override
    public void updatePerson(final ImmutableUpdatePersonRequest request, final UUID uuid) {
        final Person person = personRepository.findById(uuid).orElseThrow(PersonNotFoundException::new);
        if (StringUtils.isNotBlank(request.getFirstName())) {
            person.setFirstName(request.getFirstName());
        }
        if (StringUtils.isNotBlank(request.getLastName())) {
            person.setLastName(request.getLastName());
        }
        if (StringUtils.isNotBlank(request.getEmail())) {
            person.setEmail(request.getEmail());
        }
        if (StringUtils.isNotBlank(request.getPhone())) {
            person.setPhone(request.getPhone());
        }

        personRepository.save(person);
    }
}
