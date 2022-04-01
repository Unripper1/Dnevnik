package com.example.dnevnik.repos;

import com.example.dnevnik.entities.SleepTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SleepTrackerRepository extends JpaRepository<SleepTracker, Integer> {
}