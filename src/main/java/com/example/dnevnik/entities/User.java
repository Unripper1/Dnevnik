package com.example.dnevnik.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    @Email(message = "Email should be valid")
    private String email;
    @Min(value=18, message = "min age is 18")
    private Integer age;
    @NotNull(message = "Sex should not be empty")
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