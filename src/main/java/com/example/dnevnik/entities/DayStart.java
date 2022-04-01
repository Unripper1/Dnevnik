package com.example.dnevnik.entities;

import com.example.dnevnik.utils.Mood;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "day_start")
public class DayStart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Enumerated(EnumType.STRING)
    private Mood mood;

    @OneToMany(mappedBy = "dayStart", orphanRemoval = true)
    private List<Point> points = new ArrayList<>();

    private LocalDate date;

}