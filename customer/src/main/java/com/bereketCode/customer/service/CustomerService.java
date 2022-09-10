package com.bereketCode.customer.service;

import com.bereketCode.customer.entity.Customer;
import com.bereketCode.customer.entity.CustomerRequest;
import com.bereketCode.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record CustomerService(CustomerRepository customerRepository){
    public void CustomerRegister(CustomerRequest customerRequest){
        log.info("registered service {}",customerRequest);
        Customer customer=Customer.builder()
                .firstname(customerRequest.firstname())
                .lastname(customerRequest.lastname())
                .email(customerRequest.email())
                .build();
        customerRepository.save(customer);
    }
}
