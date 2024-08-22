package com.awesomepizza.api.services.impl;

import com.awesomepizza.api.dto.OrderDto;
import com.awesomepizza.api.dto.PizzaDto;
import com.awesomepizza.api.dto.ResponseDto;
import com.awesomepizza.api.dto.request.OrderCreateRequest;
import com.awesomepizza.api.dto.request.OrderUpdateRequest;
import com.awesomepizza.api.dto.response.OrderCreateResponse;
import com.awesomepizza.api.dto.response.OrderSearchResponse;
import com.awesomepizza.api.entity.TB_ORDER;
import com.awesomepizza.api.entity.TB_ORDER_PIZZA;
import com.awesomepizza.api.entity.TB_PIZZA;
import com.awesomepizza.api.entity.TB_STATUS;
import com.awesomepizza.api.mapper.OrderMapper;
import com.awesomepizza.api.mapper.PizzaMapper;
import com.awesomepizza.api.repository.OrderPizzaRepository;
import com.awesomepizza.api.repository.OrderRepository;
import com.awesomepizza.api.repository.PizzaRepository;
import com.awesomepizza.api.repository.StatusRepository;
import com.awesomepizza.api.services.OrderService;
import com.awesomepizza.api.utils.constant.Constant;
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
    private OrderPizzaRepository orderPizzaRepository;
    
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
        tbOrder.setCreation_user(request.getOrder().getCreationUser());

       TB_ORDER newOrder = orderRepository.save(tbOrder);
       
       if(!request.getOrder().getPizzas().isEmpty()) {

           for (PizzaDto pizza : request.getOrder().getPizzas()) {

               Optional<TB_PIZZA> tbPizza = pizzaRepository.findByCode(pizza.getCode());
               if (tbPizza.isPresent()) {
                   TB_ORDER_PIZZA orderPizzaTb = new TB_ORDER_PIZZA();
                   orderPizzaTb.setOrder(newOrder);
                   orderPizzaTb.setPizza(tbPizza.get());
                   orderPizzaRepository.save(orderPizzaTb);
               } else {
                   throw new IllegalArgumentException("Pizza not found");
               }
           }
       }
        
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
    
    @Override
    public  ResponseDto updateStatus(OrderUpdateRequest request) {
        
        if(request.getCode() == null || request.getStatus() == null) {
            throw new IllegalArgumentException("Request not valid");
        }
        
        Optional<TB_STATUS> tbStatus = statusRepository.findByCode(request.getStatus());
        if(tbStatus.isEmpty()) {
            throw new IllegalArgumentException("Status not valid");
        }
        
        Optional<TB_ORDER> tbOrder = orderRepository.findByCode(request.getCode());
        if(tbOrder.isEmpty()) {
            throw new IllegalArgumentException("Order not found");
        }
        
      if(checkStatusOrder(tbOrder.get().getStatus().getCode(),tbStatus.get().getCode())) {
          tbOrder.get().setStatus(tbStatus.get());
          tbOrder.get().setModification_date(LocalDateTime.now());
          if(tbStatus.get().getCode().equals(Constant.StatusPizza.DELETED)) {
              tbOrder.get().setDeleted(true);
              tbOrder.get().setDeletion_date(LocalDateTime.now());
          }
          orderRepository.save(tbOrder.get());
      } else {
          throw new IllegalArgumentException("Impossible to update order, status non valid");
      }
      return new ResponseDto("Order updated successfully");
    }
    
    @Override
    public ResponseDto delete (UUID code){
        
        if(code == null) {
            throw new IllegalArgumentException("Code not valid");
        }

        Optional<TB_ORDER> tbOrder = orderRepository.findByCode(code);
        if(tbOrder.isEmpty()) {
            throw new IllegalArgumentException("Order not found");
        }

        Optional<TB_STATUS> tbStatus = statusRepository.findByCode(Constant.StatusPizza.DELETED);
        if(tbStatus.isEmpty()) {
            throw new IllegalArgumentException("Status not valid");
        }
        
        tbOrder.get().setDeleted(true);
        tbOrder.get().setDeletion_date(LocalDateTime.now());
        tbOrder.get().setStatus(tbStatus.get());

        orderRepository.save(tbOrder.get());
        
        return new ResponseDto("Order deleted successfully");
    }

    @Override
    public OrderDto get (UUID code){
        
        if(code == null) {
            throw new IllegalArgumentException("Code not valid");
        }
        
        Optional<TB_ORDER> tbOrder = orderRepository.findByCode(code);
        
        if(tbOrder.isEmpty()) {
            throw new IllegalArgumentException("Order not found");
        }
        
        return orderMapper.MapEntityToDTO(tbOrder.get());
    }
    
    //Region private method
    private static boolean checkStatusOrder(String status, String newStatus){
        
        if(status.equals(Constant.StatusPizza.BOOKED) && newStatus.equals(Constant.StatusPizza.IN_PROGRESS)) {
            return true;
        }

        if(status.equals(Constant.StatusPizza.IN_PROGRESS) && newStatus.equals(Constant.StatusPizza.COMPLETED)) {
            return true;
        }

        if(status.equals(Constant.StatusPizza.BOOKED) && newStatus.equals(Constant.StatusPizza.DELETED)) {
            return true;
        }
        return false;
    }
    //end region
}

