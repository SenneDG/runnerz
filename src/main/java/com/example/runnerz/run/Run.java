package com.example.runnerz.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime endedOn,
    @Positive
    Integer miles,
    Location location

) {

    public Run {
        if(endedOn.isBefore(startedOn)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
    }
}
