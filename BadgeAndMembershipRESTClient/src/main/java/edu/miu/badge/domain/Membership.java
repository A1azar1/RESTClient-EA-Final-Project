package edu.miu.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
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
