package com.example.springesprit.services;

import com.example.springesprit.entity.ChefCuisinier;
import com.example.springesprit.repository.ChefCuisinierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ChefCuisinierService implements IChefCuisinierService {

    private final ChefCuisinierRepository chefCuisinierRepository;



    @Override
    public ChefCuisinier saveChefCuisinier(ChefCuisinier chefCuisinier) {
        return chefCuisinierRepository.save(chefCuisinier);
    }

    @Override
    public ChefCuisinier getChefCuisinierById(Long id) {
        return chefCuisinierRepository.findById(id).orElse(null);
    }

    @Override
    public List<ChefCuisinier> getAllChefCuisiniers() {
        return (List<ChefCuisinier>) chefCuisinierRepository.findAll();
    }

    @Override
    public ChefCuisinier updateChefCuisinier(Long id, ChefCuisinier chefCuisinier) {
        return chefCuisinierRepository.save(chefCuisinier);
    }

    @Override
    public void deleteChefCuisinier(Long id) {
        chefCuisinierRepository.deleteById(id);
    }

    @Override
    public List<ChefCuisinier> addChefCuisiniers(List<ChefCuisinier> chefCuisiniers) {
        return (List<ChefCuisinier>) chefCuisinierRepository.saveAll(chefCuisiniers);
    }
}
