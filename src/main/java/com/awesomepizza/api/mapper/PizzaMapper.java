package com.awesomepizza.api.mapper;

import com.awesomepizza.api.dto.OrderDto;
import com.awesomepizza.api.dto.PizzaDto;
import com.awesomepizza.api.entity.TB_ORDER;
import com.awesomepizza.api.entity.TB_PIZZA;
import org.springframework.stereotype.Component;

@Component
public class PizzaMapper {

    public PizzaDto MapEntityToDTO(TB_PIZZA tbPizza){
        PizzaDto pizza = new PizzaDto();
        pizza.setCode(tbPizza.getCode());
        pizza.setName(tbPizza.getName());
        pizza.setDescription(tbPizza.getDescription());
        pizza.setPrice(tbPizza.getPrice());
        return pizza;
    }
}
