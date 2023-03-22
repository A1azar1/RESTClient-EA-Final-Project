package edu.miu.badge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMembershipDTOs {
    List<ResponseMembershipDTO> memberships;

}
