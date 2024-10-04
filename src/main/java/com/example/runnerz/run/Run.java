package com.example.runnerz.run;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
    @Id
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime endedOn,
    @Positive
    Integer miles,
    Location location,
    @Version
    Integer version

) {

    public Run {
        if(endedOn.isBefore(startedOn)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
    }
}
