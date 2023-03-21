package edu.miu.badge.restTemplate;

import edu.miu.badge.domain.ResponseMemberDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class MemberRestTemplate {
    RestTemplate restTemplate = new RestTemplate();
    private String serverUrl = "http://localhost:8080/members";

    public List<ResponseMemberDTO> getAllMember(){
        ResponseMemberDTO[]  members = restTemplate.getForObject(serverUrl+"/", ResponseMemberDTO[].class);
        return Arrays.stream(members).toList();
    }
}
