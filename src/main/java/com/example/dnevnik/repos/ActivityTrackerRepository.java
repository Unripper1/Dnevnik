package com.example.dnevnik.repos;

import com.example.dnevnik.entities.ActivityTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTrackerRepository extends JpaRepository<ActivityTracker, Integer> {
}