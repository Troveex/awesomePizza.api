package com.awesomepizza.api.dto.response;

import com.awesomepizza.api.dto.OrderDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class OrderSearchResponse {
    
    @Getter
    @Setter
    public List<OrderDto> response = new ArrayList<>();
}
