package com.example.springesprit.services;

import com.example.springesprit.entity.Commande;

import java.util.List;

public interface ICommandeService {
    Commande saveCommande(Commande commande);
    Commande getCommandeById(Long id);
    List<Commande> getAllCommandes();
    Commande updateCommande(Long id, Commande commande);
    void deleteCommande(Long id);
    void affecterNoteACommande(Long idCommande, Long Note);
    void ajouterCommandeEtaffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu);
}
