package edu.miu.badge.domain;


import edu.miu.badge.enumeration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Transaction} entity
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class TransactionDTO implements Serializable {
    private  int id;
    private  LocalDateTime date;
    private  Member member;
    private  Membership membership;
    private  Location location;
    private TransactionType type;
}