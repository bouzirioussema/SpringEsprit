package com.example.springesprit.services;

import com.example.springesprit.entity.ChefCuisinier;

import java.util.List;

public interface IChefCuisinierService {
    ChefCuisinier saveChefCuisinier(ChefCuisinier chefCuisinier);

    ChefCuisinier getChefCuisinierById(Long id);

    List<ChefCuisinier> getAllChefCuisiniers();

    ChefCuisinier updateChefCuisinier(Long id, ChefCuisinier chefCuisinier);

    void deleteChefCuisinier(Long id);

    List<ChefCuisinier> addChefCuisiniers(List<ChefCuisinier> chefCuisiniers);
}