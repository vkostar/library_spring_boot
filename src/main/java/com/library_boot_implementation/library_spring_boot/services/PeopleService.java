package com.library_boot_implementation.library_spring_boot.services;


import com.library_boot_implementation.library_spring_boot.models.Person;
import com.library_boot_implementation.library_spring_boot.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PeopleService {

    PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Optional<Person> findById(int id) {
        return peopleRepository.findById(id);
    }

    public void save(Person person) {
        peopleRepository.save(person);
    }

    public void deleteById(int id) {
        peopleRepository.deleteById(id);
Integer id1=null;
int secn=1;
    }
}

