package com.awesomepizza.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_ORDER")
public class TB_ORDER {

    public TB_ORDER() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Setter
    @Getter
    private UUID code;
    
    @Getter
    @Setter
    private double price;

    @Column(nullable = true)
    @Setter
    @Getter
    private boolean deleted;

    @Column(nullable = true)
    @Setter
    @Getter
    private LocalDateTime deletion_date;

    @Column(nullable = true)
    @Setter
    @Getter
    private LocalDateTime modification_date;

    @Setter
    @Getter
    private LocalDateTime creation_date;

    @Setter
    @Getter 
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private TB_STATUS status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<TB_ORDER_PIZZA> pizzas;
}
