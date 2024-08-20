package com.awesomepizza.api.controller;

import com.awesomepizza.api.dto.OrderDto;
import com.awesomepizza.api.dto.request.OrderCreateRequest;
import com.awesomepizza.api.dto.response.OrderCreateResponse;
import com.awesomepizza.api.dto.response.OrderSearchResponse;
import com.awesomepizza.api.services.LookupService;
import com.awesomepizza.api.services.OrderService;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/search")
    public ResponseEntity<OrderSearchResponse> search() {
        OrderSearchResponse result = orderService.search();
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<OrderCreateResponse> create(@RequestBody OrderCreateRequest orderCreateRequest) {
        OrderCreateResponse result = orderService.create(orderCreateRequest);
        return ResponseEntity.ok(result);
    }
    
}
