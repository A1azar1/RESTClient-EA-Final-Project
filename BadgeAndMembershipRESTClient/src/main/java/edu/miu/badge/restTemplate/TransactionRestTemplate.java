package edu.miu.badge.restTemplate;

import edu.miu.badge.domain.RequestTransactionDTO;
import edu.miu.badge.domain.ResponseTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionRestTemplate {
    @Autowired
    RestTemplate restTemplate;
    @Value("${baseURL}")
    private String baseURL;
    private final String serverUrl = baseURL + "/transactions";

    public ResponseTransactionDTO postTransaction(RequestTransactionDTO transaction) {
        return restTemplate.postForObject(serverUrl, transaction, ResponseTransactionDTO.class);
    }
}
