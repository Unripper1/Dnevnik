//package com.example.dnevnik.controller;
//
//import com.example.dnevnik.entities.SleepTracker;
//import com.example.dnevnik.entities.User;
//import com.example.dnevnik.service.RegistrationService;
//import com.example.dnevnik.service.SleepTackerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//import java.security.Principal;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/sleepTracker")
//public class SleepTrackerController {
//    @Autowired
//    RegistrationService registrationService;
//    @Autowired
//    SleepTackerService sleepTackerService;
//
//    @GetMapping("/addSleep")
//    public String addSleep(@ModelAttribute("sleepTracker")SleepTracker sleepTracker)
//    {
//        return "sleepTracker";
//    }
//
//    @PostMapping("/addSleep")
//    public String addSleep(@ModelAttribute("sleepTracker") @Valid SleepTracker sleepTracker,
//                           BindingResult bindingResult,
//                           Principal principal,
//                          Map<String, Object> model)
//    {
//        User user = registrationService.getUser(principal.getName());
//        sleepTackerService.addSleep(sleepTracker, user);
//        return "sleepTracker";
//    }
//}
