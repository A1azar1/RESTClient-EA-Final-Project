package edu.miu.badge.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.badge.enumeration.BadgeStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Badge {
    private int id;
    private int badgeNumber;
    private BadgeStatus badgeStatus;
    private Member member;

}
