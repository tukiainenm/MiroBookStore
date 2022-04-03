package com.example.MiroBookStore.web;

import com.example.MiroBookStore.domain.Book;
import com.example.MiroBookStore.domain.bookRepository;
import com.example.MiroBookStore.domain.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
