package com.example.dnevnik.repos;

import com.example.dnevnik.entities.DayStart;
import com.example.dnevnik.entities.SleepTracker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface SleepTrackerRepository extends JpaRepository<SleepTracker, Integer> {
    public SleepTracker findSleepTrackerByDate(LocalDate date);
}