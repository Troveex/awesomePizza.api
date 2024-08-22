package com.awesomepizza.api.services.impl;

import com.awesomepizza.api.dto.LookupDto;
import com.awesomepizza.api.entity.TB_PIZZA;
import com.awesomepizza.api.entity.TB_STATUS;
import com.awesomepizza.api.mapper.LookupMapper;
import com.awesomepizza.api.repository.PizzaRepository;
import com.awesomepizza.api.repository.StatusRepository;
import com.awesomepizza.api.services.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LookupServiceImpl implements LookupService {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private LookupMapper lookupMapper;
    
    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public List<LookupDto> getStatus() {
      List<TB_STATUS> status = statusRepository.findAll();
      
      List<LookupDto> response = new ArrayList<>();
      
      for (TB_STATUS stat : status) {
          response.add(lookupMapper.MapEntityToDTO((stat)));
      }
        
        return response;
    }

    @Override
    public List<LookupDto> getPizzas() {
        
        List<TB_PIZZA> pizzas = pizzaRepository.findAll();

        List<LookupDto> response = new ArrayList<>();

        for (TB_PIZZA pizza : pizzas) {
            response.add(lookupMapper.MapEntityToDTO((pizza)));
        }

        return response;
    }
}
