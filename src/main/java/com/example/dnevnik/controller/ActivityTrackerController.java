package com.example.dnevnik.controller;

import com.example.dnevnik.entities.ActivityTracker;
import com.example.dnevnik.entities.SleepTracker;
import com.example.dnevnik.entities.User;
import com.example.dnevnik.service.ActivityTrackerService;
import com.example.dnevnik.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/activityTracker")
public class ActivityTrackerController {

    @Autowired
    RegistrationService registrationService;
    @Autowired
    ActivityTrackerService activityTrackerService;

    // выдает страницу с формой
    @GetMapping("/addActivity")
    public String addActivity(@ModelAttribute("activityTracker")ActivityTracker activityTracker)
    {
        return "activityTracker";
    }

    // обрабатывает форму, но нужно поменять return
    @PostMapping("/addActivity")
    public String addActivity(@ModelAttribute("activityTracker") @Valid ActivityTracker activityTracker,
                           BindingResult bindingResult,
                           Principal principal,
                           Map<String, Object> model)
    {
        User user = registrationService.getUser(principal.getName());
        activityTrackerService.addActivity(activityTracker, user);
        return "activityTracker";
    }
}
