package com.awesomepizza.api.dto.request;

import com.awesomepizza.api.dto.OrderDto;
import lombok.Getter;
import lombok.Setter;

public class OrderCreateRequest {
    
    @Getter
    @Setter
    public OrderDto order;
}
