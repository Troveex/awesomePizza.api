package com.awesomepizza.api.services;

import com.awesomepizza.api.dto.ResponseDto;
import com.awesomepizza.api.dto.request.OrderCreateRequest;
import com.awesomepizza.api.dto.request.OrderUpdateRequest;
import com.awesomepizza.api.dto.response.OrderCreateResponse;
import com.awesomepizza.api.dto.response.OrderSearchResponse;

import java.util.List;

public interface OrderService {
    
    public OrderSearchResponse search();

    public OrderCreateResponse create(OrderCreateRequest request);
    
    public ResponseDto updateStatus(OrderUpdateRequest request);
}
