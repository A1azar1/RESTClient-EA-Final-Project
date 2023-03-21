package edu.miu.badge.domain;

import edu.miu.badge.enumeration.LocationType;
import lombok.*;

import java.util.List;

/**
 *
 * @author Daniel Tsegay Meresie
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Location {
    private Long locationId;
    private String locationName;
    private String description;
    private int capacity;
    private List<TimeSlot> timeSlots;
    private LocationType locationType;
}
