package com.example.springesprit.services;

import com.example.springesprit.entity.ChefCuisinier;

import java.util.List;
import java.util.Optional;

public interface IChefCuisinierService {
    ChefCuisinier saveChefCuisinier(ChefCuisinier chefCuisinier);
    Optional<ChefCuisinier> getChefCuisinierById(Long id);
    List<ChefCuisinier> getAllChefsCuisiniers();
    void deleteChefCuisinier(Long id);
}
