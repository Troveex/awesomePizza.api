package com.awesomepizza.api.dto;

import lombok.Getter;
import lombok.Setter;

public class PizzaDto extends  LookupDto{
    
    @Setter
    @Getter
    public String name;
    
    @Getter
    @Setter
    public double price;
}
