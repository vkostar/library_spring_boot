package com.library_boot_implementation.library_spring_boot.dao;//package ru.kostar.springcourse.dao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import ru.kostar.springcourse.models.Book;
//import ru.kostar.springcourse.models.Person;
//
//import java.util.List;
//
//
//@Component
//public class PersonDAO {
//
////    private final JdbcTemplate jdbcTemplate;
////
////    @Autowired
////    public PersonDAO(JdbcTemplate jdbcTemplate) {
////        this.jdbcTemplate = jdbcTemplate;
////    }
//
////    public List<Person> index() {
////        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
////    }
//
//    public Person show(int id) {
//        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
//                .stream().findAny().orElse(null);
//    }
//
//    public void save(Person person) {
//        jdbcTemplate.update("INSERT INTO Person(name,date) VALUES(?, ?)", person.getName(), person.getDate());
//    }
//
//    public void update(int id, Person updatedPerson) {
//        jdbcTemplate.update("UPDATE Person SET name=?, date=? WHERE id=?", updatedPerson.getName(),
//                updatedPerson.getDate(), id);
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
//    }
//
//    public List<Book> showBook(int id) {
//        return jdbcTemplate.query("SELECT * FROM Person join Book on Person.id=Book.id_person where Person.id=?", new Object[]{id},
//                new BeanPropertyRowMapper<>(Book.class));
//    }
//}
