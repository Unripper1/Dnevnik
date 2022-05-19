package com.example.dnevnik.DTO;

import com.example.dnevnik.utils.Mood;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
public class DayStartDto implements Serializable {
    public final Mood mood;
}
