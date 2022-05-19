package com.example.dnevnik.service;

import com.example.dnevnik.DTO.DayStartDto;
import com.example.dnevnik.entities.DayStart;
import com.example.dnevnik.entities.Point;
import com.example.dnevnik.entities.SleepTracker;
import com.example.dnevnik.repos.DayStartRepository;
import com.example.dnevnik.repos.PointRepository;
import com.example.dnevnik.repos.SleepTrackerRepository;
import com.example.dnevnik.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DayStartService {
    @Autowired
    DayStartRepository dayStartRepository;
    @Autowired
    SleepTrackerRepository sleepTrackerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PointRepository pointRepository;
    public DayStart getDayStart(LocalDate date){
        DayStart dayStart=dayStartRepository.findDayStartByDateAndUser(date, ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        if(dayStart==null)
            return new DayStart();
        return dayStart;
    }
    public SleepTracker getSleepTracker(LocalDate date){
        return sleepTrackerRepository.findSleepTrackerByDateAndUser(date,((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
    }
    public void saveDayStart(DayStart dayStart){
        dayStartRepository.save(dayStart);
    }
    public void saveSleep(SleepTracker sleepTracker){
        sleepTrackerRepository.save(sleepTracker);
    }

    public void savePoint(Point point){
        pointRepository.save(point);
    }

}
