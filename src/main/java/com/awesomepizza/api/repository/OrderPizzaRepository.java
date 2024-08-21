package com.awesomepizza.api.repository;

import com.awesomepizza.api.entity.TB_ORDER_PIZZA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPizzaRepository extends JpaRepository<TB_ORDER_PIZZA, Long> {
}
