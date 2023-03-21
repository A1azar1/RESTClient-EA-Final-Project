package edu.miu.badge.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.badge.enumeration.BadgeStatus;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Badge {
    private int id;
    private int badgeNumber;
    private BadgeStatus badgeStatus;
    private Member member;

}
