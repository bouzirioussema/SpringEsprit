package com.example.springesprit.controller;

import com.example.springesprit.entity.Composant;
import com.example.springesprit.services.IComposantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/composant")
public class ComposantController {

    private final IComposantService composantService;

    // Ajouter un composant
    @PostMapping("/add")
    public ResponseEntity<Composant> addComposant(@RequestBody Composant composant) {
        return ResponseEntity.status(HttpStatus.CREATED).body(composantService.saveComposant(composant));
    }

    // Récupérer tous les composants
    @GetMapping("/get")
    public List<Composant> getAllComposants() {
        return composantService.getAllComposants();
    }

    // Récupérer un composant par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Composant> getComposantById(@PathVariable Long id) {
        Composant composant = composantService.getComposantById(id);
        if (composant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(composant);
    }

    // Modifier un composant
    @PutMapping("/{id}")
    public ResponseEntity<Composant> updateComposant(@PathVariable Long id, @RequestBody Composant composant) {
        Composant updatedComposant = composantService.updateComposant(id, composant);
        if (updatedComposant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedComposant);
    }

    // Supprimer un composant
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComposant(@PathVariable Long id) {
        if (composantService.getComposantById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Composant non trouvé !");
        }
        composantService.deleteComposant(id);
        return ResponseEntity.ok("Composant supprimé avec succès !");
    }
}
