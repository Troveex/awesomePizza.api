package com.awesomepizza.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ORDER_PIZZA")
public class TB_ORDER_PIZZA {
    
    public TB_ORDER_PIZZA() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private TB_ORDER order;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private TB_PIZZA pizza;
}
