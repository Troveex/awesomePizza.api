package com.awesomepizza.api.repository;

import com.awesomepizza.api.entity.TB_ORDER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<TB_ORDER, Long> {

    @Query("SELECT O FROM TB_ORDER O JOIN TB_STATUS S ON O.status.id = S.id WHERE O.deleted = FALSE ORDER BY O.creation_date DESC ")
    public List<TB_ORDER> searchOrderActive();

    @Query("SELECT SUM(P.price) FROM TB_PIZZA P JOIN TB_ORDER_PIZZA OP ON P.id_pizza = OP.pizza.id_pizza JOIN TB_ORDER O ON O.id = OP.order.id WHERE O.code = :orderCode")
    Double totalPriceOrder(@Param("orderCode") UUID orderCode);
    
    Optional<TB_ORDER> findByCode(UUID code);
    
    @Query("SELECT O.creation_user FROM TB_ORDER O ")
    List<String> getCustomers();
}
