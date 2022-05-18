package com.example.dnevnik.entities;

import com.example.dnevnik.utils.Mood;
import lombok.Data;

import java.io.Serializable;

@Data
public class EventDto implements Serializable {
    private final String name;
    private final String description;
    private final Mood mood;
}
