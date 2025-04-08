package com.example.springesprit.controller;

import com.example.springesprit.entity.ChefCuisinier;
import com.example.springesprit.services.IChefCuisinierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/chefCuisinier")
public class ChefCuisinierController {

    private final IChefCuisinierService chefCuisinierService;

    @PostMapping("/add")
    public ResponseEntity<ChefCuisinier> addChefCuisinier(@RequestBody ChefCuisinier chefCuisinier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chefCuisinierService.saveChefCuisinier(chefCuisinier));
    }

    @GetMapping("/get")
    public List<ChefCuisinier> getAllChefsCuisiniers() {
        return chefCuisinierService.getAllChefsCuisiniers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChefCuisinier> getChefCuisinierById(@PathVariable Long id) {
        return chefCuisinierService.getChefCuisinierById(id)
                .map(chefCuisinier -> ResponseEntity.ok(chefCuisinier))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteChefCuisinier(@PathVariable Long id) {
        if (chefCuisinierService.getChefCuisinierById(id).isPresent()) {
            chefCuisinierService.deleteChefCuisinier(id);
            return ResponseEntity.ok("Chef Cuisinier supprimé avec succès !");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chef Cuisinier non trouvé !");
    }

    @PutMapping("/affecter-chef-menu/{idChef}/{idMenu}")
    public ChefCuisinier affecterChefCuisinierAMenu(
            @PathVariable("idChef") Long idChef,
            @PathVariable("idMenu") Long idMenu) {
        return chefCuisinierService.affecterChefCuisinierAMenu(idChef, idMenu);
    }
}
