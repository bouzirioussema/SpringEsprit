package com.example.springesprit.controller;

import com.example.springesprit.entity.DetailComposant;
import com.example.springesprit.services.IDetailComposantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/detailComposant")
public class DetailComposantController {

    private final IDetailComposantService detailComposantService;

    // Ajouter un détail composant
    @PostMapping("/add")
    public ResponseEntity<DetailComposant> addDetailComposant(@RequestBody DetailComposant detailComposant) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detailComposantService.saveDetailComposant(detailComposant));
    }

    // Récupérer tous les détails composants
    @GetMapping("/get")
    public List<DetailComposant> getAllDetailComposants() {
        return detailComposantService.getAllDetailComposants();
    }

    // Récupérer un détail composant par son ID
    @GetMapping("/{id}")
    public ResponseEntity<DetailComposant> getDetailComposantById(@PathVariable Long id) {
        DetailComposant detailComposant = detailComposantService.getDetailComposantById(id);
        if (detailComposant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(detailComposant);
    }

    // Modifier un détail composant
    @PutMapping("/{id}")
    public ResponseEntity<DetailComposant> updateDetailComposant(@PathVariable Long id, @RequestBody DetailComposant detailComposant) {
        DetailComposant updatedDetailComposant = detailComposantService.updateDetailComposant(id, detailComposant);
        if (updatedDetailComposant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedDetailComposant);
    }

    // Supprimer un détail composant
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDetailComposant(@PathVariable Long id) {
        if (detailComposantService.getDetailComposantById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Détail composant non trouvé !");
        }
        detailComposantService.deleteDetailComposant(id);
        return ResponseEntity.ok("Détail composant supprimé avec succès !");
    }
}
