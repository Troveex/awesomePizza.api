package com.awesomepizza.api.mapper;

import com.awesomepizza.api.dto.LookupDto;
import com.awesomepizza.api.entity.TB_STATUS;
import org.springframework.stereotype.Component;

@Component
public class LookupMapper {

    public LookupDto MapEntityToDTO(TB_STATUS tbStatus){
        LookupDto lookup = new LookupDto();
        lookup.setCode(tbStatus.getCode());
        lookup.setDescription(tbStatus.getDescription());
        return lookup;
    }
}
