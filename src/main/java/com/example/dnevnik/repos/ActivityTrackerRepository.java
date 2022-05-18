package com.example.dnevnik.repos;

import com.example.dnevnik.entities.ActivityTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityTrackerRepository extends JpaRepository<ActivityTracker, Integer> {
    @Query("select at from ActivityTracker at where at.user.id in :id")
    List<ActivityTracker> findAllByUserId(@Param("id") Integer id);
}