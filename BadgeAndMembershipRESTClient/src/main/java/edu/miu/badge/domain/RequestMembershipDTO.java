package edu.miu.badge.domain;

import lombok.*;

import java.time.LocalDate;

@Data
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
