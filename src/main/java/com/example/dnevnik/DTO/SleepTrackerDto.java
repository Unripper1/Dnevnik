package com.example.dnevnik.DTO;

import com.example.dnevnik.utils.Mood;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;

@Data
public class SleepTrackerDto implements Serializable {
    private final LocalTime start;
    private final LocalTime fin;
    private final Mood result;
}
