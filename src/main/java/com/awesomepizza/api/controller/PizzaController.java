package com.awesomepizza.api.controller;

import com.awesomepizza.api.dto.response.OrderSearchResponse;
import com.awesomepizza.api.dto.response.PizzaSearchResponse;
import com.awesomepizza.api.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/pizza")
public class PizzaController {
    
    @Autowired 
    private PizzaService pizzaService;

    @GetMapping(value = "/getPizza")
    public ResponseEntity<PizzaSearchResponse> getPizza() {

        PizzaSearchResponse result = pizzaService.search();
        return ResponseEntity.ok(result);
    }
}
