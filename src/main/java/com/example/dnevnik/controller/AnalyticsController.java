package com.example.dnevnik.controller;

import com.example.dnevnik.entities.ActivityTracker;
import com.example.dnevnik.entities.User;
import com.example.dnevnik.service.AnalyticService;
import com.example.dnevnik.service.RegistrationService;
import com.example.dnevnik.utils.ActivityAnalytics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/analytics")
public class AnalyticsController {
    @Autowired
    RegistrationService registrationService;
    @Autowired
    AnalyticService analyticService;

    @GetMapping("/activityAnalytics")
    public String getActivityAnalytics(Model model, Principal principal)
    {
        User user = registrationService.getUser(principal.getName());
        model.addAttribute("activityAnalytic", analyticService.getActivityAnalytic(user));
//        model.addAttribute("moodAnalytic", analyticService.getMoodAnalytic(user));
        model.addAttribute("sleepAnalytic", analyticService.getSleepAnalytic(user));


        System.out.println(model);
        return "activityAnalytics";
    }

    @GetMapping("/moodAnalytics")
    public String getMoodAnalytics(Model model, Principal principal)
    {
        User user = registrationService.getUser(principal.getName());
        model.addAttribute("activityAnalytic", analyticService.getMoodAnalytic(user));
        return "activityAnalytics";
    }

    @GetMapping("/sleepAnalytics")
    public String getSleepAnalytics(Model model, Principal principal)
    {
        User user = registrationService.getUser(principal.getName());
        model.addAttribute("activityAnalytic", analyticService.getSleepAnalytic(user));
        return "activityAnalytics";
    }
}
