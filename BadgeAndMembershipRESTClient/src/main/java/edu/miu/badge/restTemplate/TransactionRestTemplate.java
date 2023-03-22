package edu.miu.badge.restTemplate;

import edu.miu.badge.domain.RequestTransactionDTO;
import edu.miu.badge.domain.ResponseTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionRestTemplate {
    @Autowired
    RestTemplate restTemplate;
    @Value("${myserver.url}")
    private String baseURL;


    public ResponseTransactionDTO postTransaction(RequestTransactionDTO transaction, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+ token);
        HttpEntity<Object> entity = new HttpEntity<>(transaction,headers);

        return restTemplate.exchange( baseURL + "/transactions", HttpMethod.POST,
                entity,ResponseTransactionDTO.class).getBody();
    }
}
