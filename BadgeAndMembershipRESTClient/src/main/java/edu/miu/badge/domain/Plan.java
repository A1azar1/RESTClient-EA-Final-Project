package edu.miu.badge.domain;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Data
@NoArgsConstructor
public class Plan {

    private Integer id;

    private String name;

    private String description;
    private List<PlanType> planTypes;
    private List<Location> locations;
    private List<Role> allowedRoles;

}
