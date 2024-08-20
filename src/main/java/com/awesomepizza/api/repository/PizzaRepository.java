package com.awesomepizza.api.repository;

import com.awesomepizza.api.entity.TB_PIZZA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PizzaRepository extends JpaRepository<TB_PIZZA, Long> {

    @Query("SELECT P FROM TB_PIZZA P JOIN TB_ORDER_PIZZA OP ON P.id_pizza = OP.pizza.id_pizza JOIN TB_ORDER O ON O.id = OP.order.id WHERE O.code = :orderCode")
    List<TB_PIZZA> findPizzaByOrderCode(@Param("orderCode") UUID orderCode);
    
}