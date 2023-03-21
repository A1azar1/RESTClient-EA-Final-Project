package edu.miu.badge.domain;


import edu.miu.badge.enumeration.PlanTypeEnum;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanType {

    private Integer id;
    private PlanTypeEnum planType;

}
