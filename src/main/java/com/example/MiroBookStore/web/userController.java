package com.example.MiroBookStore.web;

import com.example.MiroBookStore.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class userController {

    @Autowired
    private userRepository uRepository;

    @RequestMapping(value = "/signup")
    public String addUser(Model model) {
        model.addAttribute("signUpForm", new signUpForm());
        return "signUp";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signUpForm") signUpForm signUpForm, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            if (signUpForm.getPassword().equals(signUpForm.getPasswordCheck())) {
                String pwd = signUpForm.getPassword();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashPwd = passwordEncoder.encode(pwd);

                User newUser = new User();
                newUser.setPasswordHash(hashPwd);
                newUser.setUserName(signUpForm.getUsername());
                newUser.setRole("USER");
                if (uRepository.findByUserName(signUpForm.getUsername()) == null) {
                    uRepository.save(newUser);
                } else {
                    bindingResult.rejectValue("username", "err.username", "Username already exists");
                    return "signUp";
                }
            } else {
                bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");
                return "signUp";
            }
        } else {
            return "signUp";
        }
        return "redirect:/login";
    }
}


