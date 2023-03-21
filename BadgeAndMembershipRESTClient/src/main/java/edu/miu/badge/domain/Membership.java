package edu.miu.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Membership {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Plan plan;
    private PlanType planType;
    private int numberOfAllowance;
}
