package com.example.translate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double rankSpeed=0;
    private double rankSatisfaction=0;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderForm order;
}
