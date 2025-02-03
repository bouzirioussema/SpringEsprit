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


    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Composant> composant;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Composant> commande;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ChefCuisinier> chefCuisiniers;
}
