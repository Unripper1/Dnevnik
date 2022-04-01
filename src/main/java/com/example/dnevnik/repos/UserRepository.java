package com.example.dnevnik.repos;

import com.example.dnevnik.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}