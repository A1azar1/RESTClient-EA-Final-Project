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
public class RequestMembershipDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private int member_id;
    private int plan_id;
    private int planType_id;
    private int numberOfAllowance;
}
