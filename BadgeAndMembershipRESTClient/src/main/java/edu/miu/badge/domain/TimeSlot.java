package edu.miu.badge.domain;

import edu.miu.badge.enumeration.DayOfTheWeek;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

/**
 *
 * @author Daniel Tsegay Meresie
 */

@Setter @Getter @AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {
    private Long timeSlotId;
    private LocalTime startTime;
    private LocalTime endTime;
    private  DayOfTheWeek day;
}
