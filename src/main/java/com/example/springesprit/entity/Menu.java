package com.example.springesprit.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMenu;

    private String libelleMenu;
    private Float prixTotal;

    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu;


    @OneToMany
    private List<Composant> composant;

    @OneToMany
    private List<Composant> commande;

    @ManyToMany
    private List<ChefCuisinier> chefCuisiniers;
}
