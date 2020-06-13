package com.example.translate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class EvaluationT {
    private int id;
    private double rankSpeed=0;
    private double rankSatisfaction=0;
    private String content;
    private OrderForm order;
    private String name;
}
