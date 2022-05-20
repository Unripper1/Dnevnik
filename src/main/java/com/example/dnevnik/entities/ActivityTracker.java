package com.example.dnevnik.entities;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    private LocalDate date;

    @NotNull(message = "Should not be empty")
    private Integer hobbyTime;
    @NotNull(message = "Should not be empty")
    private Integer workTime;
    @NotNull(message = "Should not be empty")
    private Integer sportTime;
    @NotNull(message = "Should not be empty")
    private Integer studyTime;
    @NotNull(message = "Should not be empty")
    private Integer socialTime;

}