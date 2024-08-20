package com.awesomepizza.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_STATUS")
public class TB_STATUS {

    public TB_STATUS() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Setter
    @Getter
    private String code;

    @Setter
    @Getter
    private String description;

    @OneToMany(mappedBy = "status") // Questo è corretto per la parte inversa di una ManyToOne
    @Setter
    @Getter
    private List<TB_ORDER> order = new ArrayList<>();
}
