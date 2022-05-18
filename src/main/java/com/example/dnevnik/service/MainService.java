package com.example.dnevnik.service;
import com.example.dnevnik.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainService{
    DayStart getTodayStart();
    SleepTracker getTodaySleepTracker();
    ActivityTracker getTodayActivityTracker();

    List<DayStart> getAllStarts();
    List<SleepTracker> getAllSleepTrackers();
    List<ActivityTracker> getAllActivityTrackers();

    void setTodayStart(DayStart dayStart);
    void setTodaySleepTracker(SleepTracker sleepTracker);
    void setTodayActivityTracker(ActivityTracker activityTracker);

    void addEvent(Event event);
    void addPoint(Point point);
    void updatePoint(Point point,Boolean result);
}
