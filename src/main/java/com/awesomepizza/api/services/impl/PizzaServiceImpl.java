package com.awesomepizza.api.services.impl;

import com.awesomepizza.api.dto.LookupDto;
import com.awesomepizza.api.dto.PizzaDto;
import com.awesomepizza.api.dto.response.OrderSearchResponse;
import com.awesomepizza.api.dto.response.PizzaSearchResponse;
import com.awesomepizza.api.entity.TB_PIZZA;
import com.awesomepizza.api.entity.TB_STATUS;
import com.awesomepizza.api.mapper.PizzaMapper;
import com.awesomepizza.api.repository.PizzaRepository;
import com.awesomepizza.api.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;
    
    @Autowired
    private PizzaMapper pizzaMapper;

    @Override
    public PizzaSearchResponse search() {

        List<TB_PIZZA> pizzas = pizzaRepository.findAll();

        List<PizzaDto> pizzaList = new ArrayList<>();
        
        for (TB_PIZZA pizza : pizzas) {
            pizzaList.add(pizzaMapper.MapEntityToDTO((pizza)));
        }
        PizzaSearchResponse response = new PizzaSearchResponse();
        response.setResponse(pizzaList);
        return response;
    }

}
