package com.example.dnevnik.repos;

import com.example.dnevnik.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}