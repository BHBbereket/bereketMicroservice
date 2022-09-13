package com.bereketCode.customer.controller;

import com.bereketCode.customer.entity.Customer;
import com.bereketCode.customer.entity.CustomerRequest;
import com.bereketCode.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/customer")
@Slf4j
public class CustomerContoller {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public  void registerCustomer(@RequestBody CustomerRequest customer){
        log.info("new coustomer registration {}",customer);
        customerService.CustomerRegister(customer);
    }
}
