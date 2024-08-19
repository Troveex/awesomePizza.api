package com.awesomepizza.api.services.impl;

import com.awesomepizza.api.dto.LookupDto;
import com.awesomepizza.api.entity.TB_STATUS;
import com.awesomepizza.api.mapper.LookupMapper;
import com.awesomepizza.api.repository.LookupRepository;
import com.awesomepizza.api.services.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LookupServiceImpl implements LookupService {

    @Autowired
    private LookupRepository lookupRepository;

    @Autowired
    private LookupMapper lookupMapper;

    @Override
    public List<LookupDto> getStatus() {
      List<TB_STATUS> status = lookupRepository.findAll();
      
      List<LookupDto> response = new ArrayList<>();
      
      for (TB_STATUS statu : status) {
          response.add(lookupMapper.MapEntityToDTO((statu)));
      }
        
        return response;
    }
}
