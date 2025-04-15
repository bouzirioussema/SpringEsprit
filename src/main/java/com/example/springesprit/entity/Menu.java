package com.example.springesprit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMenu;

    private String libelleMenu;
    private Float prixTotal;

    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu;

    @ManyToOne
    private Restaurant restaurant; // Lien avec le restaurant

    @OneToMany
    private List<Composant> composants;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Commande> commandes;

    @ManyToMany
    @JoinTable(
            name = "menu_chef_cuisinier",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "chef_cuisinier_id")
    )
    private List<ChefCuisinier> chefCuisiniers;


}
