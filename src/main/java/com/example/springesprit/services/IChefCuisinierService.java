package com.example.springesprit.services;

import com.example.springesprit.entity.ChefCuisinier;
import com.example.springesprit.entity.TypeChef;

import java.util.List;
import java.util.Optional;

public interface IChefCuisinierService {
    ChefCuisinier saveChefCuisinier(ChefCuisinier chefCuisinier);
    Optional<ChefCuisinier> getChefCuisinierById(Long id);
    List<ChefCuisinier> getAllChefsCuisiniers();
    void deleteChefCuisinier(Long id);
    ChefCuisinier affecterChefCuisinierAMenu(Long idChefCuisinier, Long idMenu);
    ChefCuisinier desaffecterChefCuisinierDuMenu(Long idChefCuisinier, Long idMenu);
    List<ChefCuisinier> listChefCuisinierByTypeChefAndRestaurant(TypeChef typeChef, String nomRestaurant);
}
