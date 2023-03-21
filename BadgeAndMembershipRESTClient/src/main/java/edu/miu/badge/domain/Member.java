package edu.miu.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Role> roles;
    private List<Badge> badges;
    private List<Membership> memberships;
}
