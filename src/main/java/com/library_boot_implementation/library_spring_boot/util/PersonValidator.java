package com.library_boot_implementation.library_spring_boot.util;

import com.library_boot_implementation.library_spring_boot.models.Person;
import com.library_boot_implementation.library_spring_boot.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class PersonValidator implements Validator {

    PeopleRepository peopleRepository;

    @Autowired
    public PersonValidator(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (peopleRepository.getPersonByDate(person.getDate()).isPresent())
            errors.rejectValue("date", "", "Ты совем того шоле? Повторяешься мальчик...");
    }
}
