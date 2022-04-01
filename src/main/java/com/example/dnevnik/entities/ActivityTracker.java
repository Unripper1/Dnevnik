package com.example.dnevnik.entities;

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
@Table(name = "activity_tracker")
public class ActivityTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "activityTracker", orphanRemoval = true)
    private List<Exercise> exercises = new ArrayList<>();

    private LocalDate date;

    private Integer hobbyTime;
    private Integer workTime;
    private Integer sportTime;
    private Integer studyTime;
    private Integer socialTime;

}