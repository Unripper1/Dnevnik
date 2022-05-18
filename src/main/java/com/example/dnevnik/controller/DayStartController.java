package com.example.dnevnik.controller;

import com.example.dnevnik.DTO.DayStartDto;
import com.example.dnevnik.DTO.PointDto;
import com.example.dnevnik.DTO.SleepTrackerDto;
import com.example.dnevnik.entities.DayStart;
import com.example.dnevnik.entities.Point;
import com.example.dnevnik.entities.SleepTracker;
import com.example.dnevnik.service.DayStartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/daystart")
public class DayStartController {
    @Autowired
    DayStartService dayStartService;
//    @GetMapping("/{date}")
//    public String getDay(Model model){
//        model.addAttribute("dayStart", dayStartService.getDayStart(LocalDate.now()));
//        model.addAttribute("sleepTracker", dayStartService.getSleepTracker(LocalDate.now()));
//        return "todayDayStart";
//    }
    @GetMapping("/today")
    public String getToday(Model model){
        model.addAttribute("dayStart", dayStartService.getDayStart(LocalDate.now()));
        model.addAttribute("sleepTracker", dayStartService.getSleepTracker(LocalDate.now()));
        return "todayDayStart";
    }

    @PostMapping("/today/setstart")
    public String setTodayDayStart(DayStartDto dayStartDto, Model model){
        DayStart dayStart= dayStartService.getDayStart(LocalDate.now());
        dayStart.setDate(LocalDate.now());
        dayStart.setMood(dayStartDto.getMood());
        //dayStart.setUser(); Добавить currentUser
        dayStartService.saveDayStart(dayStart);
        model.addAttribute("dayStart", dayStartService.getDayStart(LocalDate.now()));
        model.addAttribute("sleepTracker", dayStartService.getSleepTracker(LocalDate.now()));
        return "todayDayStart";
    }

    @PostMapping("/today/setsleep")
    public String setTodaySleep(SleepTrackerDto sleepTrackerDto, Model model){
        SleepTracker sleepTracker=new SleepTracker();
        sleepTracker.setDate(LocalDate.now());
        sleepTracker.setStart(sleepTrackerDto.getStart());
        sleepTracker.setFin(sleepTrackerDto.getFin());
        sleepTracker.setResult(sleepTrackerDto.getResult());
        //sleepTracker.setUser(); Добавить currentUser
        dayStartService.saveSleep(sleepTracker);
        model.addAttribute("dayStart", dayStartService.getDayStart(LocalDate.now()));
        model.addAttribute("sleepTracker", dayStartService.getSleepTracker(LocalDate.now()));
        return "todayDayStart";
    }

    @PostMapping("/today/setpoint")
    public String setTodaySleep(PointDto pointDto, Model model){
        DayStart dayStart= dayStartService.getDayStart(LocalDate.now());
        Point point=new Point();
        point.setDescription(pointDto.getDescription());
        point.setDayStart(dayStart);
        dayStartService.savePoint(point);
        model.addAttribute("dayStart", dayStartService.getDayStart(LocalDate.now()));
        model.addAttribute("sleepTracker", dayStartService.getSleepTracker(LocalDate.now()));
        return "todayDayStart";
    }


}
