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
        DayStart dayStart=dayStartRepository.findDayStartByDateAndUser(date,  userRepository.findByName(SecurityContextHolder.getContext().getAuthentication().getName()));
        if(dayStart==null) {
            DayStart dayStart1=new DayStart();
            dayStart1.setDate(LocalDate.now());
            dayStart1.setUser(userRepository.findByName(SecurityContextHolder.getContext().getAuthentication().getName()));
            dayStartRepository.save(dayStart1);
            return dayStart1;

        }
        return dayStart;
    }
    public SleepTracker getSleepTracker(LocalDate date){
        return sleepTrackerRepository.findSleepTrackerByDateAndUser(date, userRepository.findByName(SecurityContextHolder.getContext().getAuthentication().getName()));
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
