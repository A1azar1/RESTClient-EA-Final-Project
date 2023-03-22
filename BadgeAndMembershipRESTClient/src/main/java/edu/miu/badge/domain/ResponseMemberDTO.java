package edu.miu.badge.domain;

import lombok.*;

import java.util.List;

@Data
@ToString(exclude = {"badges", "memberships"})
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMemberDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<RolesDTO> roles;
}
