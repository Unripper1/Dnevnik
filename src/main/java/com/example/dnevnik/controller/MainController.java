package com.example.dnevnik.controller;

import com.example.dnevnik.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public interface MainController {
    @GetMapping
    String getMainPage(Model model);

    @GetMapping("/registration")
    String getRegistrationPage();

    @PostMapping("/registration")
    String doRegistration(User user);

    @GetMapping("/login")
    String login();

    @PostMapping
    String setStartDay(DayStart dayStart);

    @PostMapping
    String setSleepTracker(SleepTracker sleepTracker);

    @PostMapping
    String setActivityTracker(ActivityTracker activityTracker);

    @PostMapping
    String addEvent(Event event);

    @PostMapping
    String addPoint(Event event);

    @PostMapping
    String updateExercise(Exercise exercise, Boolean result);

    @PostMapping
    String updatePoint(Point point, Boolean result);

}
