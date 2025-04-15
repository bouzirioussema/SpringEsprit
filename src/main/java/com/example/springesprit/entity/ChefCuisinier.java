package com.example.springesprit.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ChefCuisinier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private int etoiles;

    @Enumerated(EnumType.STRING)
    private TypeChef typeChef;

    @ManyToOne
    private Restaurant restaurant;
}
