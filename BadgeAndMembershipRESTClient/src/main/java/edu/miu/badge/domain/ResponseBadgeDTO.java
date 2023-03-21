package edu.miu.badge.domain;


import edu.miu.badge.enumeration.BadgeStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Badge} entity
 */

@Data
@NoArgsConstructor
public class ResponseBadgeDTO implements Serializable {

    private  int id;
    private BadgeStatus badgeStatus;
    private int badgeNumber;
    private ResponseMemberDTO member;

}