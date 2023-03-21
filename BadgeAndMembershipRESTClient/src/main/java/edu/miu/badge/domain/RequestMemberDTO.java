package edu.miu.badge.domain;


import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMemberDTO {
    private String firstName;
    private String lastName;
    private String email;
    private List<Integer> roles;
}
