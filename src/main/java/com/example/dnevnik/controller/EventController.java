package com.example.dnevnik.controller;

import com.example.dnevnik.entities.Event;
import com.example.dnevnik.entities.EventDto;
import com.example.dnevnik.repos.EventRepository;
import com.example.dnevnik.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/today")
    public String getEvents(Model model){
        model.addAttribute("events",eventRepository.findAllByDateAndUser(LocalDate.now(),userRepository.findByName(SecurityContextHolder.getContext().getAuthentication().getName())));
        return "eventsToday";
    }

    @PostMapping("/add")
    public String setEvent(EventDto eventDto, Model model){
        Event event=new Event();
        event.setDate(LocalDate.now());
        event.setDescription(eventDto.getDescription());
        event.setName(eventDto.getName());
        event.setMood(eventDto.getMood());
        event.setUser(userRepository.findByName(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));
        eventRepository.save(event);
//        model.addAttribute("events",eventRepository.findAllByDateAndUser(LocalDate.now(),userRepository.findByName(SecurityContextHolder.getContext().getAuthentication().getName())));
        return "redirect:/events/today";
    }

}
