package com.library_boot_implementation.library_spring_boot.repositories;



import com.library_boot_implementation.library_spring_boot.models.Book;
import com.library_boot_implementation.library_spring_boot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByPerson(Person person);
    List<Book> findAllByNameStartsWith(String query);
}
