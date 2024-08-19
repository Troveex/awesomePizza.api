package com.awesomepizza.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
