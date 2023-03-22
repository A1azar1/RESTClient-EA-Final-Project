package edu.miu.badge.restTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.badge.domain.RequestUserDTO;
import edu.miu.badge.domain.ResponseMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class LoginRestTemplate {
    public static String token="";
    @Autowired
    RestTemplate restTemplate;
    @Value("${myserver.url}")
    private String baseURL;


    public ResponseMemberDTO login(String username, String password) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        RequestUserDTO user = new RequestUserDTO(username, password);
        HttpEntity<?> entity = new HttpEntity<>(user); // for request
        HttpEntity<String> response = restTemplate.exchange(baseURL+"/users/login", HttpMethod.POST, entity, String.class);
        ResponseMemberDTO result= mapper.readValue(response.getBody(), ResponseMemberDTO.class);
        HttpHeaders headers = response.getHeaders();
        token =  Objects.requireNonNull(headers.get("token")).get(0);
        return  result;
    }


}
