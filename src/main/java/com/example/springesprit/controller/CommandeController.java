package com.example.springesprit.controller;

import com.example.springesprit.entity.Commande;
import com.example.springesprit.services.ICommandeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/commande")
public class CommandeController {

    private final ICommandeService commandeService;

    @PostMapping("/add")
    public ResponseEntity<?> addCommande(@RequestBody Commande commande) {
        try {
            Commande newCommande = commandeService.saveCommande(commande);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCommande);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur : " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        return commandeService.updateCommande(id, commande);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCommande(@PathVariable Long id) {
        if (commandeService.getCommandeById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Commande non trouvée !");
        }
        commandeService.deleteCommande(id);
        return ResponseEntity.ok("Commande supprimée avec succès !");
    }
}
