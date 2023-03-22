package edu.miu.badge.domain;


import edu.miu.badge.enumeration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTransactionDTO {
    private  int id;
    private LocalDateTime date;
    private ResponseMemberDTO member;
    private ResponseMembershipDTO membership;
    private LocationDTO location;
    private TransactionType type;

    @Override
    public String toString() {
        return "{\"ResponseTransactionDTO\":{"
                + "                        \"id\":\"" + id + "\""
                + ",                         \"date\":" + date
                + ",                         \"member\":" + member
                + ",                         \"membership\":" + membership
                + ",                         \"location\":" + location
                + ",                         \"type\":\"" + type + "\""
                + "}}";
    }
}
