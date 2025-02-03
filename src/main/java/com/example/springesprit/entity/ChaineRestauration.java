package com.example.springesprit.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class ChaineRestauration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChaineRestauration;

    private String libelle;
    private LocalDate dateCreation;

    @OneToMany
    private List<Restaurant> restaurant;
}