package com.library_boot_implementation.library_spring_boot.controllers;

import com.library_boot_implementation.library_spring_boot.models.Book;
import com.library_boot_implementation.library_spring_boot.models.Person;
import com.library_boot_implementation.library_spring_boot.services.BookService;
import com.library_boot_implementation.library_spring_boot.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;
    private final PeopleService peopleService;


    @Autowired
    public BookController(BookService bookService, PeopleService peopleService) {

        this.bookService = bookService;
        this.peopleService = peopleService;


    }


    @GetMapping()
    public String indexBook(Model model, @RequestParam(value = "page", required = false) Integer page,
                            @RequestParam(value = "itemsPerPage", required = false) Integer itemsPerPage,
                            @RequestParam(value = "sorted",required = false) Boolean sorted) {

        model.addAttribute("books", bookService.findAll(page, itemsPerPage, sorted));


        return "books/index";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("books") Book book) {

        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("books") Book book,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "books/new";
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookService.findById(id).get());
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "books/edit";
        book.setId(id);
        bookService.save(book);
        return "redirect:/books";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("book", bookService.findById(id));

        Optional<Book> book = bookService.findById(id);
        Person bookOwner = book.get().getPerson();
        if (bookOwner != null) {
            model.addAttribute("owner", bookOwner);
        } else {
            model.addAttribute("people", peopleService.findAll());
        }

        return "books/page";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/assign")
    public String assign(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        bookService.assign(person, id);
        return "redirect:/books/" + id;
    }

    @PostMapping("/{id}/untouched")
    public String untouched(@PathVariable("id") int id) {
        bookService.untouched(id);
        return "redirect:/books/" + id;
    }

    @GetMapping("/search")
    public String search() {
        return "books/search";
    }

    @PostMapping("/search")
    public String search(Model model,@RequestParam String query) {
        model.addAttribute("searched_book", bookService.findByQuery(query));
        return "books/search";
    }



}
