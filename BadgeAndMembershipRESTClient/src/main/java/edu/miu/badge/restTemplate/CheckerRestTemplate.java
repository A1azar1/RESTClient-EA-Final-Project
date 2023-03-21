package edu.miu.badge.restTemplate;


import edu.miu.badge.domain.ResponseMembershipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CheckerRestTemplate {
    @Autowired
    RestTemplate restTemplate ;
    private String serverUrl = "http://localhost:8080/members";

    public List<ResponseMembershipDTO> getAllMembershipOfMember(int memberId){
        ResponseMembershipDTO[]  memberships = restTemplate.getForObject(serverUrl+"/"+memberId+"/memberships", ResponseMembershipDTO[].class,memberId);
        return Arrays.stream(memberships).toList();
    }
}
