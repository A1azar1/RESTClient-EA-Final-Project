package edu.miu.badge.restTemplate;

import edu.miu.badge.domain.Member;
import edu.miu.badge.domain.ResponseMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoginRestTemplate {
    @Autowired
    RestTemplate restTemplate ;
    private String serverUrl = "http://localhost:8080/login";

    public ResponseMemberDTO login(String username, String password){
        ResponseMemberDTO memberDTO = new ResponseMemberDTO();
        memberDTO.setId(1);
        return memberDTO;
    }


}
