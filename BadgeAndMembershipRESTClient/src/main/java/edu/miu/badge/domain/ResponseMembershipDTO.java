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
    private Member member;
    private Plan plan;
    private PlanType planType;
    private int numberOfAllowance;

    @Override
    public String toString() {
        return "{\"ResponseMembershipDTO\":{"
                + "                        \"\nid\":\"" + id + "\""
                + ",                         \"\nstartDate\":" + startDate
                + ",                         \"\nendDate\":" + endDate
                + ",                         \"\nmember\":" + member
                + ",                         \"\nplan\":" + plan
                + ",                         \"\nplanType\":" + planType
                + ",                         \"\nnumberOfAllowance\":\"" + numberOfAllowance + "\""
                + "}}";
    }
}
