package com.bereket.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1")
public class FraudController {
    @Autowired
    private FraudService service;
    @GetMapping("/fraudcheck/{cust_id}")
    public FraudCheckResponce isFraudster(@PathVariable int cust_id){
        boolean isFraudster=service.isFraudulentCustomer(cust_id);
       // System.out.println(isFraudster);
        FraudCheckResponce check=new FraudCheckResponce();
        check.setIsfraud(isFraudster);
        System.out.println(check.isIsfraud());
        return check;
    }


}
