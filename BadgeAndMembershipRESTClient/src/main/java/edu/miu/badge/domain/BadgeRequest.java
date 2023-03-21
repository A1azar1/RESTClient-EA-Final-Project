package edu.miu.badge.domain;

import edu.miu.badge.enumeration.BadgeStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BadgeRequest {
    private BadgeStatus badgeStatus;
    private int memberId;
}
