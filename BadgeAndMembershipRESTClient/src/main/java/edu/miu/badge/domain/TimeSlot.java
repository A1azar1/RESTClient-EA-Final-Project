package edu.miu.badge.domain;

import edu.miu.badge.enumeration.DayOfTheWeek;

import lombok.*;

import java.time.LocalTime;

/**
 *
 * @author Daniel Tsegay Meresie
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {
    private Long timeSlotId;
    private LocalTime startTime;
    private LocalTime endTime;
    private  DayOfTheWeek day;
}
