//package com.example.dnevnik.service;
//
//import com.example.dnevnik.entities.SleepTracker;
//import com.example.dnevnik.entities.User;
//import com.example.dnevnik.repos.SleepTrackerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//@Service
//@Transactional
//public class SleepTackerService {
//    @Autowired
//    SleepTrackerRepository sleepTrackerRepository;
//
//    public void addSleep(SleepTracker sleepTracker, User user){
//        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        LocalDate localDate = LocalDate.now();
//        //System.out.println(dtf.format(localDate)); // 2 016/11/16
//
//        sleepTracker.setUser(user);
//        sleepTracker.setDate(LocalDate.now());
//        System.out.println(sleepTracker.toString());
//        sleepTrackerRepository.save(sleepTracker);
//    }
//}
