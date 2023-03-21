package edu.miu.badge.domain;

import lombok.*;

import java.time.LocalDateTime;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@Data @AllArgsConstructor
@NoArgsConstructor @ToString
public class TimeSlotDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
