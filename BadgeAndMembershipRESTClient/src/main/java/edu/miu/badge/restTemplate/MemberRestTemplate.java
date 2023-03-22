package edu.miu.badge.restTemplate;

import edu.miu.badge.domain.ResponseBadgeDTO;
import edu.miu.badge.domain.ResponseMemberDTO;
import edu.miu.badge.domain.ResponseMembershipDTO;
import edu.miu.badge.domain.ResponseMembershipDTOs;
import edu.miu.badge.enumeration.BadgeStatus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MemberRestTemplate {
    @Autowired
    RestTemplate restTemplate;
    @Value("${myserver.url}")
    private String baseURL;


    public List<ResponseMemberDTO> getAllMember() {
        ResponseMemberDTO[] members = restTemplate.getForObject(baseURL +"/members", ResponseMemberDTO[].class);
        return Arrays.stream(members).toList();
    }
    public List<ResponseMembershipDTO> getAllMembershipOfMember(int memberId, String token) {
        //send token in header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+ token);
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseMembershipDTO[] list= restTemplate.exchange(baseURL + "/members/" + memberId + "/memberships",
                HttpMethod.GET,
                entity,ResponseMembershipDTO[].class).getBody();
        return Arrays.asList(list);
    }

    public boolean getMemberActiveBadge(int memberId, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+ token);
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseBadgeDTO[] badges = restTemplate
                .exchange(baseURL + "/members/" + memberId + "/badges",
                        HttpMethod.GET,entity,ResponseBadgeDTO[].class).getBody();
        boolean result= Arrays.stream(badges).anyMatch(badge ->
                badge.getBadgeStatus().equals(BadgeStatus.ACTIVE));
        return result;
    }
}
