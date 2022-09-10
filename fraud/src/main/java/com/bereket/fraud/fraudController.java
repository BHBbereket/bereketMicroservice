package com.bereket.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v2/fraudcheck")
public class fraudController {
    @Autowired
    private FraudService service;
    @GetMapping("/{cust_id}")
    public FraudCheckResponce isFraudster(@PathVariable int cust_id){
        boolean isFraudster=service.isFraudulentCustomer(cust_id);
        return new FraudCheckResponce(isFraudster);
    }


}
