package edu.miu.badge.client;

import edu.miu.badge.domain.Member;
import edu.miu.badge.domain.ResponseBadgeDTO;
import edu.miu.badge.domain.ResponseMemberDTO;
import edu.miu.badge.domain.ResponseMembershipDTO;
import edu.miu.badge.enumeration.BadgeStatus;
import edu.miu.badge.enumeration.PlanTypeEnum;
import edu.miu.badge.restTemplate.CheckerRestTemplate;
import edu.miu.badge.restTemplate.LoginRestTemplate;
import edu.miu.badge.restTemplate.MemberRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication(scanBasePackages = {"edu.miu.badge.restTemplate"})
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	MemberRestTemplate memberRestTemplate;
	@Autowired
	CheckerRestTemplate checkerRestTemplate;
	@Autowired
	LoginRestTemplate loginRestTemplate;
	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		ResponseMemberDTO memberDTO = loginRestTemplate.login("admin", "admin");
		Optional<List<ResponseMembershipDTO>> membershipDTOList =
				Optional.of(checkerRestTemplate.getAllMembershipOfMember(memberDTO.getId())
						.stream()
						.filter(m -> m.getPlanType().getPlanType().equals(PlanTypeEnum.CHECKER)).toList());
		if(membershipDTOList.get().size()==0){
			System.out.println("No Checker membership found");
			return;
		}
		System.out.println("Select a membership to check badge:");
		membershipDTOList.ifPresent(membershipDTOS -> {
			membershipDTOS.forEach(m -> System.out.println(m.getId() + " " + m.getPlan().getName()));
		});
		int membershipId = scanner.nextInt();
		int planId= membershipDTOList.get().stream().filter(m -> m.getId() == membershipId).findFirst().get().getPlan().getId();
		System.out.println("Choice selected : "+membershipId);
		membershipDTOList.ifPresent(membershipDTOS -> {
			membershipDTOS.forEach(m -> m.getPlan().getLocations()
					.stream().forEach(l -> System.out.println(l.getLocationId() + " " + l.getLocationName())));
		});
		int locationId = scanner.nextInt();
		System.out.println("Selected Location : "+locationId);
		System.out.println("Ready to Scan Badge!!!!");
		Thread.sleep(1000);
		System.out.println("Scanning Minalu's Badge");
		Thread.sleep(200);
		


	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
