package edu.miu.badge.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.miu.badge.domain.*;
import edu.miu.badge.enumeration.PlanTypeEnum;
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


@SpringBootApplication(scanBasePackages = {"edu.miu.badge.restTemplate"})
public class RestClientApplication implements CommandLineRunner {
    @Autowired
    MemberRestTemplate memberRestTemplate;
    @Autowired
    LoginRestTemplate loginRestTemplate;
    @Autowired
    TransactionRestTemplate transactionRestTemplate;
    String token = "";

    public static void main(String[] args) {
        SpringApplication.run(RestClientApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Badge and Membership System");
        do {
            System.out.println("Press 1 to Login");
            int choice = scanner.nextInt();
            if (choice == 1) {
                login(scanner);
            } else {
                System.out.println("Invalid choice");
            }
        } while (true);
    }

    public void login(Scanner scanner) throws JsonProcessingException, InterruptedException {

        do {
            System.out.print("Enter username: ");
            String username = scanner.next().trim();
            System.out.print("Enter password: ");
            String password = scanner.next().trim();

            ResponseMemberDTO memberDTO = loginRestTemplate.login(username, password);
            if (memberDTO == null) {
                System.out.println("Invalid username or password");
            } else {
                token = LoginRestTemplate.token;
                List<ResponseMembershipDTO> membershipDTOList =
                        memberRestTemplate.getAllMembershipOfMember(memberDTO.getId(), token)
                                .stream().filter(m -> m.getPlanType().getPlanType().equals(PlanTypeEnum.CHECKER)).toList();

                if (membershipDTOList.size() == 0) {
                    System.out.println("No Checker membership found");
                    System.out.println("Do you want to login again? (Y/N)");
                    String choice = scanner.next();
                    if (choice.equalsIgnoreCase("Y")) {
                        continue; //login again
                    } else {
                        System.out.println("Thank you for using Badge and Membership System");
                        return;
                    }
                } else {
                    System.out.println("Which membership do you want to use?");
                    membershipDTOList.forEach(m -> System.out.println(m.getId() + " " + m.getPlan().getName()));
                    System.out.print("Enter membership id:");
                    int membershipId = scanner.nextInt();
                    int planId = membershipDTOList.stream().filter(m -> m.getId() == membershipId).findFirst().get().getPlan().getId();
                    System.out.println("Membership selected: " + membershipId);
                    System.out.println("Select a location to check badge:");
                    membershipDTOList.stream().filter(ms -> ms.getId() == membershipId)
                            .findFirst().get().getPlan().getLocations().stream()
                            .forEach(l -> System.out.println(l.getLocationId() + " " + l.getLocationName() ));
                    int locationId = scanner.nextInt();
                    System.out.println("Selected Location : " + locationId);
                    System.out.println("Ready to Scan Badge!!!!");
                    Thread.sleep(1000);
                    int input = 1;
                    do {
                        Thread.sleep(1000);
                        System.out.println("Input Badge Number: ");
                        int badgeNumber = scanner.nextInt();
                        System.out.println("Scanning !!!!!");
                        if (memberRestTemplate.getMemberActiveBadge(badgeNumber,token)) {
                            System.out.println("No active badge found");
                        } else {
                            scanBadge(new RequestTransactionDTO(badgeNumber, planId, locationId));
                        }
                        System.out.println("Press 1 to continue scanning : Press 0 to exist ");
                        input = scanner.nextInt();
                    } while (input == 1);
                    System.out.println("Thank you for using Badge and Membership System");
                }

            }
        } while (true);

    }

    public void scanBadge(RequestTransactionDTO req) {
        try{
            System.out.println(transactionRestTemplate.postTransaction(req, token));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
