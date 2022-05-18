package com.example.dnevnik.service;

import com.example.dnevnik.entities.ActivityTracker;
import com.example.dnevnik.entities.DayStart;
import com.example.dnevnik.entities.SleepTracker;
import com.example.dnevnik.entities.User;
import com.example.dnevnik.repos.ActivityTrackerRepository;
import com.example.dnevnik.repos.DayStartRepository;
import com.example.dnevnik.repos.SleepTrackerRepository;
import com.example.dnevnik.utils.ActivityAnalytics;
import com.example.dnevnik.utils.MoodAnalytics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnalyticService {
    @Autowired
    ActivityTrackerRepository activityTrackerRepository;
    @Autowired
    DayStartRepository dayStartRepository;
    @Autowired
    SleepTrackerRepository sleepTrackerRepository;

    public MoodAnalytics getSleepAnalytic(User user) {
        int total = 0, very_sad = 0, sad = 0, fine = 0, good = 0, very_good = 0;
        List<SleepTracker> dayStarts = sleepTrackerRepository.
                findAllByUserId(user.getId());
        for (SleepTracker i: dayStarts){
            switch (i.getResult()){
                case SAD: sad+=1;
                    break;
                case FINE: fine+=1;
                    break;
                case GOOD: good+=1;
                    break;
                case VERY_SAD: very_sad+=1;
                    break;
                case VERY_GOOD: very_good+=1;
                    break;
            }
        }
        total += (very_sad + sad + fine + good + very_good);
        try{
            return new MoodAnalytics(
                    (very_sad*100)/total,
                    (sad*100)/total,
                    (fine*100)/total,
                    (good*100)/total,
                    (very_good*100)/total
            );
        } catch (Exception e){
            return  new MoodAnalytics(0,0,0,0,0);
        }
    }

    public MoodAnalytics getMoodAnalytic(User user) {
        int total = 0, very_sad = 0, sad = 0, fine = 0, good = 0, very_good = 0;
        List<DayStart> dayStarts = dayStartRepository.
                findAllByUserId(user.getId());
        for (DayStart i: dayStarts){
            switch (i.getMood()){
                case SAD: sad+=1;
                    break;
                case FINE: fine+=1;
                    break;
                case GOOD: good+=1;
                    break;
                case VERY_SAD: very_sad+=1;
                    break;
                case VERY_GOOD: very_good+=1;
                    break;
            }
        }
        total += (very_sad + sad + fine + good + very_good);
        try{
            return new MoodAnalytics(
                    (very_sad*100)/total,
                    (sad*100)/total,
                    (fine*100)/total,
                    (good*100)/total,
                    (very_good*100)/total
            );
        } catch (Exception e){
            return  new MoodAnalytics(0,0,0,0,0);
        }
    }

    public ActivityAnalytics getActivityAnalytic(User user){
        int total = 0, hobby = 0, social = 0, sport = 0, study = 0, work = 0;
        List<ActivityTracker> activity = activityTrackerRepository.
                findAllByUserId(user.getId());
        for (ActivityTracker i: activity){
            hobby += i.getHobbyTime();
            social+=i.getSocialTime();
            sport+=i.getSportTime();
            study+=i.getStudyTime();
            work+=i.getWorkTime();
        }
        total = hobby + social + study + sport + work;
        try {
            return new ActivityAnalytics(
                    (hobby * 100) / total,
                    (social * 100) / total,
                    (sport * 100) / total,
                    (study * 100) / total,
                    (work * 100) / total);
        }
        catch (Exception e){ return new ActivityAnalytics(0,0,0,0,0); }
    }
}
