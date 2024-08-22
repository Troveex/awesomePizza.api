package com.awesomepizza.api.services.impl;

import com.awesomepizza.api.dto.CustomerDto;
import com.awesomepizza.api.dto.response.CustomerSearchResponse;
import com.awesomepizza.api.repository.OrderRepository;
import com.awesomepizza.api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public CustomerSearchResponse search() {
    
       List<String> users =  orderRepository.getCustomers();
       
       CustomerSearchResponse response = new CustomerSearchResponse();
       List<CustomerDto> list = new ArrayList<>();
       
       for(String user: users) {
           CustomerDto customerDto = new CustomerDto();
           customerDto.setName(user);
           list.add(customerDto);
       }
       response.setCustomers(list);
       
       return response;
    }        
}
