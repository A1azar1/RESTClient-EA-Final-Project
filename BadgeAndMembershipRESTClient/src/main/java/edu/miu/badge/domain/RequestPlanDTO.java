package edu.miu.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RequestPlanDTO {
    private String name;
    private String description;
    private List<Integer> planTypesId;
    private List<Long> locationsId;
    private List<Integer> allowedRolesId;
}
