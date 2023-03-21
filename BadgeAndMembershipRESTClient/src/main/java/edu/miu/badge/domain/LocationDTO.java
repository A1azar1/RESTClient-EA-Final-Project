package edu.miu.badge.domain;

import edu.miu.badge.enumeration.LocationType;
import lombok.*;

import java.util.List;
/**
 *
 * @author Daniel Tsegay Meresie
 */

@Setter @Getter @AllArgsConstructor
@NoArgsConstructor @ToString
public class LocationDTO {
    private Long locationId;
    private String locationName;
    private String description;
    private int capacity;
    private LocationType locationType;
    private List<TimeSlotDTO> timeslots;
}
