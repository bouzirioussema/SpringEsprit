package com.example.springesprit.repository;

import com.example.springesprit.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {




    List<Restaurant> findByNbPlacesMaxGreaterThanAndChainerestaurationDateCreationBefore(Long capacite, LocalDate date);
    Restaurant findByNom(String nom);


}
