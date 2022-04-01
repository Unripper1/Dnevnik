package com.example.dnevnik.repos;

import com.example.dnevnik.entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Integer> {
}