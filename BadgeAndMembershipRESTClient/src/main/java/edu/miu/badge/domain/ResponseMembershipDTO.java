package edu.miu.badge.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMembershipDTO {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Member member;
    private Plan plan;
    private PlanType planType;
    private int numberOfAllowance;
}
