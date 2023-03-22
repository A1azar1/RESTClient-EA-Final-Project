package edu.miu.badge.client;

import edu.miu.badge.domain.*;
import edu.miu.badge.enumeration.BadgeStatus;
import edu.miu.badge.enumeration.PlanTypeEnum;
import edu.miu.badge.restTemplate.CheckerRestTemplate;
import edu.miu.badge.restTemplate.LoginRestTemplate;
import edu.miu.badge.restTemplate.MemberRestTemplate;
import edu.miu.badge.restTemplate.TransactionRestTemplate;
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
	@Autowired
	TransactionRestTemplate transactionRestTemplate;
	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Badge and Membership System");
		System.out.println("1. Login");
		System.out.println("2. Exit");
		int choice = scanner.nextInt();
		switch (choice){
			case 1:
				login(scanner);
				break;
			case 2:
				System.out.println("Thank you for using Badge and Membership System");
				break;
			default:
				System.out.println("Invalid choice");
				break;
		}
	}

	public void login(Scanner scanner) throws InterruptedException {
		System.out.println("Enter username:");
		String username = scanner.next();
		System.out.println("Enter password:");
		String password = scanner.next();
		ResponseMemberDTO memberDTO = loginRestTemplate.login(username, password);
		if(memberDTO == null){
			System.out.println("Invalid username or password");
			return;
		}
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
		System.out.println("Select a location to check badge:");
		membershipDTOList.ifPresent(membershipDTOS -> {
			membershipDTOS.forEach(m -> m.getPlan().getLocations().forEach(l -> System.out.println(l.getLocationId() + " " + l.getLocationName())));
		});
		int locationId = scanner.nextInt();
		System.out.println("Selected Location : "+locationId);
		System.out.println("Ready to Scan Badge!!!!");
		Thread.sleep(1000);
		int input = 1;
		do{
			Thread.sleep(1000);
			System.out.println("Input Badge Number: ");
			int badgeNumber = scanner.nextInt();
			System.out.println("Scanning !!!!!");
			scanBadge(new RequestTransactionDTO(badgeNumber,7,2));
			System.out.println("Press 1 to continue scanning   : Press 0 to exist ");
			input = scanner.nextInt();
		}
		while (input == 1);
		System.out.println("Thank you for using Badge and Membership System");
	}
	public void scanBadge(RequestTransactionDTO req){
	System.out.println(transactionRestTemplate.postTransaction(req));
}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
