package com.awesomepizza.api.dto.response;

import com.awesomepizza.api.dto.PizzaDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class PizzaSearchResponse {

    @Getter
    @Setter
    public List<PizzaDto> response = new ArrayList<>();
}
