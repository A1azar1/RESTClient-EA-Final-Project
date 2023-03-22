package edu.miu.badge.domain;


import edu.miu.badge.enumeration.PlanTypeEnum;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanTypeDTO {

    private Integer id;
    private PlanTypeEnum planType;

}
