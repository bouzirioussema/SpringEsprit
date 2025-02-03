package com.example.springesprit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idRestaurant; // Clé primaire
    private String nom;
    private Long nbPlacesMax;

    @ManyToOne
    private ChaineRestauration chaineRestauration;

    @OneToMany
    private List<Menu> menu;

}