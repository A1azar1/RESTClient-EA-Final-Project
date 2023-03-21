package edu.miu.badge.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class PlanDTO {
    private Integer id;
    private String name;
    private String description;
    private List<PlanType> planTypes;
    private List<Location> locations;
    private List<Role> allowedRoles;
}
