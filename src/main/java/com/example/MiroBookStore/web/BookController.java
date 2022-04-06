package com.example.MiroBookStore.web;

import com.example.MiroBookStore.domain.Book;
import com.example.MiroBookStore.domain.bookRepository;
import com.example.MiroBookStore.domain.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private bookRepository repository;

    @Autowired
    private categoryRepository cRepository;

    @RequestMapping(value = {"/", "/booklist"})
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "bookList";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepository.findAll());
        return "addBook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findById(id));
        model.addAttribute("categories", cRepository.findAll());
        return "editBook";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveEditedBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> BookListRest() {
        return (List<Book>) repository.findAll();
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Book> findBookRest(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

}
