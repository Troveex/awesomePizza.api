package com.awesomepizza.api.controller;

import com.awesomepizza.api.dto.OrderDto;
import com.awesomepizza.api.dto.ResponseDto;
import com.awesomepizza.api.dto.request.OrderCreateRequest;
import com.awesomepizza.api.dto.request.OrderUpdateRequest;
import com.awesomepizza.api.dto.response.OrderCreateResponse;
import com.awesomepizza.api.dto.response.OrderSearchResponse;
import com.awesomepizza.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping(value = "/get")
    public ResponseEntity<OrderDto> get(@RequestParam UUID code) {
        OrderDto result = orderService.get(code);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<OrderCreateResponse> create(@RequestBody OrderCreateRequest orderCreateRequest) {
        OrderCreateResponse result = orderService.create(orderCreateRequest);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/update-status")
    public ResponseEntity<ResponseDto> updateStatus(@RequestBody OrderUpdateRequest orderUpdateRequest) {
        ResponseDto result = orderService.updateStatus(orderUpdateRequest);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ResponseDto> delete(@RequestParam UUID code) {
        ResponseDto result = orderService.delete(code);
        return ResponseEntity.ok(result);
    }
}
