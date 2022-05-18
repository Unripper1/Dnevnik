package com.example.dnevnik.service;

import com.example.dnevnik.entities.ActivityTracker;
import com.example.dnevnik.entities.SleepTracker;
import com.example.dnevnik.entities.User;
import com.example.dnevnik.repos.ActivityTrackerRepository;
import com.example.dnevnik.repos.SleepTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class ActivityTrackerService {
    @Autowired
    ActivityTrackerRepository activityTrackerRepository;

    public void addActivity(ActivityTracker activityTracker, User user){
        activityTracker.setUser(user);
        activityTracker.setDate(LocalDate.now());
        System.out.println(activityTracker.toString());
        activityTrackerRepository.save(activityTracker);
    }
}
