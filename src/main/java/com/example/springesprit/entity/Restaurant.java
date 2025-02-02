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
    @JoinColumn(name="chaineRestauration_id")
    private ChaineRestauration chaineRestauration;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> menu;

}