package com.example.dnevnik.DTO;

import com.example.dnevnik.utils.Mood;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SleepTrackerDto implements Serializable {
    private final LocalDateTime start;
    private final LocalDateTime fin;
    private final Mood result;
}
