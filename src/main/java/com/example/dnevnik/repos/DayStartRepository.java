package com.example.dnevnik.repos;

import com.example.dnevnik.entities.DayStart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface DayStartRepository extends JpaRepository<DayStart, Integer> {
    public DayStart findDayStartByDate(LocalDate date);
}