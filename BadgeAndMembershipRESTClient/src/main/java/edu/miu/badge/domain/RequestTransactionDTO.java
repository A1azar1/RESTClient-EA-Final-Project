package edu.miu.badge.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestTransactionDTO {
    private Integer badgeId;
    private Integer planId;
    private Integer locationId;
}
