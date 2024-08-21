package com.awesomepizza.api.mapper;

import com.awesomepizza.api.dto.LookupDto;
import com.awesomepizza.api.dto.OrderDto;
import com.awesomepizza.api.entity.TB_ORDER;
import com.awesomepizza.api.entity.TB_STATUS;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDto MapEntityToDTO(TB_ORDER tbOrder){
        OrderDto order = new OrderDto();
        order.setCode(tbOrder.getCode());
        order.setStatus(tbOrder.getStatus().getCode());
        order.setDeleted(tbOrder.isDeleted());
        order.setCreationDate(tbOrder.getCreation_date());
        order.setCreationUser(tbOrder.getCreation_user());
        order.setDeletionDate(tbOrder.getDeletion_date());
        order.setModificationDate(tbOrder.getModification_date());
        order.setPrice(tbOrder.getPrice());
        return order;
    }
}
