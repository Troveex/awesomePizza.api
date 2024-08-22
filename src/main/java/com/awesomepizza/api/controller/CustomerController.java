package com.awesomepizza.api.controller;

import com.awesomepizza.api.dto.CustomerDto;
import com.awesomepizza.api.dto.response.CustomerSearchResponse;
import com.awesomepizza.api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/search-customer")
    public ResponseEntity<CustomerSearchResponse> get() {
        CustomerSearchResponse result = customerService.search();
        return ResponseEntity.ok(result);
    }
}
