package com.awesomepizza.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderDto {

    @Setter
    @Getter
    public UUID code;

    @Setter
    @Getter
    public String status;
    
    @Getter
    @Setter
    public double price;

    @Setter
    @Getter
    public boolean deleted = false;

    @Setter
    @Getter
    public LocalDateTime deletionDate;

    @Setter
    @Getter
    public LocalDateTime creationDate;

    @Setter
    @Getter
    public LocalDateTime modificationDate;
    
    @Getter
    @Setter
    public List<PizzaDto> pizzas;
    
    public OrderDto() {}
}
