package com.example.springesprit.controller;

import com.example.springesprit.entity.ChefCuisinier;
import com.example.springesprit.entity.Restaurant;
import com.example.springesprit.services.IRestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final IRestaurantService restaurantService;

    // Ajouter un restaurant
    @PostMapping("/add")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.saveRestaurant(restaurant));
    }


    // Récupérer tous les restaurants
    @GetMapping("/get")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // Récupérer un restaurant par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if (restaurant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(restaurant);
    }

    // Modifier un restaurant
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
        if (updatedRestaurant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedRestaurant);
    }

    // Supprimer un restaurant
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        if (restaurantService.getRestaurantById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant non trouvé !");
        }
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok("Restaurant supprimé avec succès !");
    }

    @PutMapping("/affecter-restaurant/{nomRestaurant}/{libelleChaine}")
    public Restaurant affecterRestaurantAChaineRestauration(
            @PathVariable("nomRestaurant") String nomRestaurant,
            @PathVariable("libelleChaine") String libelleChaine) {
        return restaurantService.affecterRestaurantAChaineRestauration(nomRestaurant, libelleChaine);
    }
}
