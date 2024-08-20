package com.awesomepizza.api.services.impl;

import com.awesomepizza.api.dto.OrderDto;
import com.awesomepizza.api.dto.PizzaDto;
import com.awesomepizza.api.dto.ResponseDto;
import com.awesomepizza.api.dto.request.OrderCreateRequest;
import com.awesomepizza.api.dto.response.OrderCreateResponse;
import com.awesomepizza.api.dto.response.OrderSearchResponse;
import com.awesomepizza.api.entity.TB_ORDER;
import com.awesomepizza.api.entity.TB_PIZZA;
import com.awesomepizza.api.entity.TB_STATUS;
import com.awesomepizza.api.mapper.OrderMapper;
import com.awesomepizza.api.mapper.PizzaMapper;
import com.awesomepizza.api.repository.OrderRepository;
import com.awesomepizza.api.repository.PizzaRepository;
import com.awesomepizza.api.repository.StatusRepository;
import com.awesomepizza.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private StatusRepository statusRepository;
    
    @Autowired
    private PizzaRepository pizzaRepository;
    
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PizzaMapper pizzaMapper;

    @Override
    public OrderSearchResponse search() {
        
        List<TB_ORDER> orders = orderRepository.searchOrderActive();

        List<OrderDto> orderList = new ArrayList<>();

        for (TB_ORDER order : orders) {
            OrderDto newOrder = orderMapper.MapEntityToDTO((order));
            List<PizzaDto> listOrderPizza = new ArrayList<>();
            
            List<TB_PIZZA> pizzaList =  pizzaRepository.findPizzaByOrderCode(order.getCode());
            for (TB_PIZZA pizza : pizzaList) {
                PizzaDto pizzaOrder = pizzaMapper.MapEntityToDTO(pizza);
                listOrderPizza.add(pizzaOrder);
            }
            newOrder.setPrice(orderRepository.totalPriceOrder(order.getCode()));
            newOrder.setPizzas(listOrderPizza);
            orderList.add(newOrder);
        }
        OrderSearchResponse response = new OrderSearchResponse();
        response.setResponse(orderList);
        return response;
    }
    
    @Override
    public OrderCreateResponse create(OrderCreateRequest request) {
        
        if(request.getOrder().getPrice() == 0) {
            throw new IllegalArgumentException("Price not valid");
        }
        
       Optional<TB_STATUS> findStatus = statusRepository.findByCode(request.getOrder().getStatus());
        
       TB_STATUS status = new TB_STATUS();
       if(findStatus.isPresent()) {
           status = findStatus.get();
       } else {
        throw new IllegalArgumentException("Status not found");
       }
        UUID uuid = UUID.randomUUID();
        
        TB_ORDER tbOrder = new TB_ORDER();
        tbOrder.setStatus(status);
        tbOrder.setCode(uuid);
        tbOrder.setCreation_date(LocalDateTime.now());
        tbOrder.setDeleted(false);
        tbOrder.setPrice(request.getOrder().getPrice());

       TB_ORDER newOrder = orderRepository.save(tbOrder);
        
       OrderCreateResponse response = new OrderCreateResponse();
        if(newOrder != null) {
            response.setResponse(new ResponseDto("Order created successfully"));
            return response;
        }
        ResponseDto orderNotCreated = new ResponseDto();
        orderNotCreated.setStatus(false);
        orderNotCreated.setMessage("Order not created");
        
        response.setResponse(orderNotCreated);
        return response;
    }
}
