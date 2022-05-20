package com.example.dnevnik.repos;

import com.example.dnevnik.entities.ActivityTracker;
import com.example.dnevnik.entities.DayStart;
import com.example.dnevnik.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DayStartRepository extends JpaRepository<DayStart, Integer> {
    public DayStart findDayStartByDateAndUser(LocalDate date, User name);

    @Query("select at from DayStart at where at.user.id in :id")
    List<DayStart> findAllByUserId(@Param("id") Integer id);
}