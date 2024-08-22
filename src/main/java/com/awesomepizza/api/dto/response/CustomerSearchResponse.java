package com.awesomepizza.api.dto.response;

import com.awesomepizza.api.dto.CustomerDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

public class CustomerSearchResponse {
    
    @Getter
    @Setter
    List<CustomerDto> customers;
}
