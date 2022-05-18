package com.example.dnevnik.repos;

import com.example.dnevnik.entities.DayStart;
import com.example.dnevnik.entities.SleepTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SleepTrackerRepository extends JpaRepository<SleepTracker, Integer> {
    public SleepTracker findSleepTrackerByDate(LocalDate date);

    @Query("select at from SleepTracker at where at.user.id in :id")
    List<SleepTracker> findAllByUserId(@Param("id") Integer id);
}