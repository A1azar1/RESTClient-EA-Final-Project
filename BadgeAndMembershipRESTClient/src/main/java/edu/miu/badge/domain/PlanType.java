package edu.miu.badge.domain;


import edu.miu.badge.enumeration.PlanTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanType {

    private Integer id;
    private PlanTypeEnum planType;

}
