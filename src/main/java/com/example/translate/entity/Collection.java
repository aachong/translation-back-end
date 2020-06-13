package com.example.translate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String query;
    private String translation;
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserInformation userInformation;
}
