package com.bereketCode.customer.service;

import com.bereketCode.customer.entity.Customer;
import com.bereketCode.customer.entity.CustomerRequest;
import com.bereketCode.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CustomerService{
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CustomerRepository customerRepository;
    private boolean checkfraud(int cust_id){
        return false;
    }
    public void CustomerRegister(CustomerRequest customerRequest){
        log.info("registered service {}",customerRequest);
        Customer customer=Customer.builder()
                .firstname(customerRequest.firstname())
                .lastname(customerRequest.lastname())
                .email(customerRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);
        int id=customer.getId();
        String url="http://localhost:9090/api/v1/fraudcheck/"+customer.getId();


        FraudCheckResponce1 responce=restTemplate.getForObject(url, FraudCheckResponce1.class);
        System.out.println(responce.isIsfraud());
       // assert responce != null;
       // log.info("fraud result is {}",responce.customer());
//        if(responce.isFraudster()){
//            throw new IllegalStateException("fraud happened");
//        }


    }
}
