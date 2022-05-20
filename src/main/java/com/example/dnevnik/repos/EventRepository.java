package com.example.dnevnik.repos;

import com.example.dnevnik.entities.Event;
import com.example.dnevnik.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    public List<Event> findAllByDateAndUser(LocalDate date, User name);
}