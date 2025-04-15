package com.example.springesprit.controller;

import com.example.springesprit.entity.Composant;
import com.example.springesprit.entity.Menu;
import com.example.springesprit.services.IMenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {

    private final IMenuService menuService;

    // Ajouter un menu
    @PostMapping("/add")
    public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {
        Menu newMenu = menuService.addMenu(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMenu);
    }

    // Récupérer tous les menus
    @GetMapping("/get")
    public ResponseEntity<List<Menu>> getAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        return ResponseEntity.ok(menus);
    }

    // Récupérer un menu par son ID
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getMenuById(@PathVariable Long id) {
        Menu menu = menuService.getMenuById(id);
        if (menu == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Menu avec ID " + id + " non trouvé !");
        }
        return ResponseEntity.ok(menu);
    }

    // Modifier un menu
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMenu(@PathVariable Long id, @RequestBody Menu menu) {
        if (menuService.getMenuById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Menu avec ID " + id + " non trouvé !");
        }
        Menu updatedMenu = menuService.updateMenu(id, menu);
        return ResponseEntity.ok(updatedMenu);
    }

    // Supprimer un menu
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable Long id) {
        if (menuService.getMenuById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Menu avec ID " + id + " non trouvé !");
        }
        menuService.deleteMenu(id);
        return ResponseEntity.ok("Menu avec ID " + id + " supprimé avec succès !");
    }

    // Ajouter des composants à un menu et mettre à jour le prix
    @PutMapping("/add-composants/{idMenu}")
    public ResponseEntity<?> ajoutComposantsEtMiseAjourPrixMenu(
            @PathVariable Long idMenu, 
            @RequestBody Set<Composant> composants) {
        try {
            Menu updatedMenu = menuService.ajoutComposantsEtMiseAjourPrixMenu(composants, idMenu);
            return ResponseEntity.ok(updatedMenu);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Filtrer les menus par type et prix minimum
    @GetMapping("/filter")
    public ResponseEntity<List<Menu>> getMenusByTypeAndMinPrice(
            @RequestParam TypeMenu typeMenu,
            @RequestParam Float prixTotal) {
        List<Menu> menus = menuService.listeMenuSelonTypeMenuEtprixComposantsSuperieurAUnMontant(typeMenu, prixTotal);
        return ResponseEntity.ok(menus);
    }
}
