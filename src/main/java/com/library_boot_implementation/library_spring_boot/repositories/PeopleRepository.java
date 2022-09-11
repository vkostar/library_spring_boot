package com.library_boot_implementation.library_spring_boot.repositories;


import com.library_boot_implementation.library_spring_boot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person, Integer> {


   Optional<Person> getPersonByDate(Date date);
}
