package com.example.dnevnik.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String password;
    private String email;
    private Integer age;
    private Character sex;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<DayStart> dayStarts = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<ActivityTracker> activityTrackers = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<SleepTracker> sleepTrackers = new ArrayList<>();

}