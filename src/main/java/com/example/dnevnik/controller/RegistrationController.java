package com.example.dnevnik.controller;

import com.example.dnevnik.entities.User;
import com.example.dnevnik.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                          Map<String, Object> model) {
        // ошибки при заполнении формы
        if (bindingResult.hasErrors())
            return "registration";

        System.out.println("pass form check");
        User testUser = registrationService.createUser(user);
        if (testUser == null){
            model.put("message", "Пользователь с таким именем уже существует!");
            return "registration";
        } else
            System.out.println(testUser.getName() + testUser.getPassword());
            return "redirect:/login";
    }
}
