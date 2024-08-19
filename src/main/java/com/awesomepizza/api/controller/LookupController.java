package com.awesomepizza.api.controller;

import com.awesomepizza.api.dto.LookupDto;
import com.awesomepizza.api.services.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/lookups")
public class LookupController {

    @Autowired
    private LookupService lookupService;

    @GetMapping(value = "/getStatus")
    public ResponseEntity<List<LookupDto>> getStatus() {
        
        List<LookupDto> lookupDto = lookupService.getStatus();
        return ResponseEntity.ok(lookupDto);
    }

    @GetMapping(value = "/getPizzas")
    public List<LookupDto> getPizzas() {

        List<LookupDto> lookupDtos = new ArrayList<>();
        return lookupDtos;
    }
}
