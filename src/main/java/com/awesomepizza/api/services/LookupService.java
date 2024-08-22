package com.awesomepizza.api.services;

import com.awesomepizza.api.dto.LookupDto;

import java.util.List;

public interface LookupService  {
    
    public List<LookupDto> getStatus();

    public List<LookupDto> getPizzas();

}
