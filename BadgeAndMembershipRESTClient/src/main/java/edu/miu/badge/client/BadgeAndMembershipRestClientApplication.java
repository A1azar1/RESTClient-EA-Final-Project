package edu.miu.badge.client;

import edu.miu.badge.domain.ResponseMemberDTO;
import edu.miu.badge.restTemplate.MemberRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"edu.miu.badge.restTemplate"})
public class BadgeAndMembershipRestClientApplication implements CommandLineRunner {
	@Autowired
	MemberRestTemplate memberRestTemplate;
	public static void main(String[] args) {
		SpringApplication.run(BadgeAndMembershipRestClientApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		List<ResponseMemberDTO> memberDTOList = memberRestTemplate.getAllMember();
		for (ResponseMemberDTO m : memberDTOList){
			System.out.println(m);
		}
	}
}
