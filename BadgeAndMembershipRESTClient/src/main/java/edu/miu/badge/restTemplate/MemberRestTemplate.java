package edu.miu.badge.restTemplate;

import edu.miu.badge.domain.ResponseBadgeDTO;
import edu.miu.badge.domain.ResponseMemberDTO;
import edu.miu.badge.domain.ResponseMembershipDTO;
import edu.miu.badge.enumeration.BadgeStatus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MemberRestTemplate {
    @Autowired
    RestTemplate restTemplate;
    @Value("${baseURL}")
    private String baseURL;
    private final String serverUrl = baseURL + "/members";

    public List<ResponseMemberDTO> getAllMember() {
        ResponseMemberDTO[] members = restTemplate.getForObject(serverUrl, ResponseMemberDTO[].class);
        return Arrays.stream(members).toList();
    }
    public List<ResponseMembershipDTO> getAllMembershipOfMember(int memberId) {
        ResponseMembershipDTO[] memberships = restTemplate.getForObject(serverUrl + "/" + memberId + "/memberships", ResponseMembershipDTO[].class, memberId);
        return Arrays.stream(memberships).toList();
    }

    public Optional<ResponseBadgeDTO> getMemberActiveBadge(int memberId) {
        ResponseBadgeDTO[] badges = restTemplate.getForObject(serverUrl + "/" + memberId + "/badges", ResponseBadgeDTO[].class, memberId);
        return Optional.of(Arrays.stream(badges).filter(badge -> badge.getBadgeStatus().equals(BadgeStatus.ACTIVE)).findFirst().get());
    }
}
