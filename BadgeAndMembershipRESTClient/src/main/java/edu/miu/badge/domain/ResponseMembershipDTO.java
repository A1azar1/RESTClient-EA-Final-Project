package edu.miu.badge.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMembershipDTO {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private ResponseMemberDTO member;
    private ResponsePlanDTO plan;
    private PlanTypeDTO planType;
    private int usedAllowances;

}
