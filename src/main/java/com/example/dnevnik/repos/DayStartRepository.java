package com.example.dnevnik.repos;

import com.example.dnevnik.entities.DayStart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayStartRepository extends JpaRepository<DayStart, Integer> {
}