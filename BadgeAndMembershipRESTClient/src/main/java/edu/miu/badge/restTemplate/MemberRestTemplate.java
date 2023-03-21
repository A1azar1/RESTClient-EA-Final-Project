package edu.miu.badge.restTemplate;

import edu.miu.badge.domain.ResponseBadgeDTO;
import edu.miu.badge.domain.ResponseMemberDTO;
import edu.miu.badge.enumeration.BadgeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class MemberRestTemplate {
    @Autowired
    RestTemplate restTemplate ;
    private String serverUrl = "http://localhost:8080/members";

    public List<ResponseMemberDTO> getAllMember(){
        ResponseMemberDTO[]  members = restTemplate.getForObject(serverUrl, ResponseMemberDTO[].class);
        return Arrays.stream(members).toList();
    }

    public ResponseBadgeDTO getMemberActiveBadge(int memberId){
        ResponseBadgeDTO[] badges = restTemplate.getForObject(serverUrl + "/" + memberId + "/badges", ResponseBadgeDTO[].class,memberId);
        return Arrays.stream(badges).filter(badge -> badge.getBadgeStatus().equals(BadgeStatus.ACTIVE)).findFirst().get();
    }
}
