package com.awesomepizza.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "TB_PIZZA")
public class TB_PIZZA {

    public TB_PIZZA() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id_pizza;

    @Setter
    @Getter
    private String code;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private double price;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL)
    private List<TB_ORDER_PIZZA> orders;
    
}
