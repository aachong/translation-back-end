package com.example.translate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Translator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String password;
    private String phone;
    private String email;
    private int money = 0;
    private int numberOrder;

    private double rankSpeed=0;
    private double rankSatisfaction=0;
    private int rankPerson=0;  //评价次数

}
