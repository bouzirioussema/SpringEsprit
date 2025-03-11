package com.example.springesprit.controller;

import com.example.springesprit.entity.ChaineRestauration;
import com.example.springesprit.services.IChaineRestaurationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/chaineRestauration")
public class ChaineRestaurationController {

    private final IChaineRestaurationService chaineRestaurationService;

    // Ajouter une chaîne de restauration
    @PostMapping("/add")
    public ResponseEntity<ChaineRestauration> addChaineRestauration(@RequestBody ChaineRestauration chaineRestauration) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chaineRestaurationService.saveChaineRestauration(chaineRestauration));
    }

    // Récupérer toutes les chaînes de restauration
    @GetMapping("/get")
    public List<ChaineRestauration> getAllChainesRestauration() {
        return chaineRestaurationService.getAllChainesRestauration();
    }

    // Récupérer une chaîne de restauration par son ID
    @GetMapping("/{id}")
    public ResponseEntity<ChaineRestauration> getChaineRestaurationById(@PathVariable Long id) {
        return chaineRestaurationService.getChaineRestaurationById(id)
                .map(chaineRestauration -> ResponseEntity.ok(chaineRestauration))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Supprimer une chaîne de restauration
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteChaineRestauration(@PathVariable Long id) {
        if (chaineRestaurationService.getChaineRestaurationById(id).isPresent()) {
            chaineRestaurationService.deleteChaineRestauration(id);
            return ResponseEntity.ok("Chaîne de restauration supprimée avec succès !");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chaîne de restauration non trouvée !");
    }
}
