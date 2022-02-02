package com.example.MiroBookStore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @RequestMapping("/index")
    public String viewBooks() {
        return "";
    }
}
