package com.example.dnevnik.entities;

import com.example.dnevnik.utils.Mood;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "sleep_tracker")
public class SleepTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate date;

    private LocalDateTime start;
    private LocalDateTime fin;
    @Enumerated(EnumType.STRING)
    private Mood result;

    @Override
    public String toString() {
        return "SleepTracker{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", start=" + start +
                ", fin=" + fin +
                ", result=" + result +
                '}';
    }
}