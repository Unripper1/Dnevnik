package com.example.dnevnik.repos;

import com.example.dnevnik.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    public List<Event> findAllByDate(LocalDate date);
}