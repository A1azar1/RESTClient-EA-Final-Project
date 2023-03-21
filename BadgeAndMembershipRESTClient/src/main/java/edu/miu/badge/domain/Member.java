package edu.miu.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
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
