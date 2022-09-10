package com.bereket.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudService {
    @Autowired
    private FraudRepository repository;

    public Boolean isFraudulentCustomer(int cust_id){
        repository.save(FraudCheckHistory.builder()
                        .customerId(cust_id)
                        .isFrauded(false)
                        .createdAt(LocalDateTime.now())
                .build());
        return false;
    }
}
