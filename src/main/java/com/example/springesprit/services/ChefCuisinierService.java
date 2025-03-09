package com.example.springesprit.services;

import com.example.springesprit.entity.ChefCuisinier;
import com.example.springesprit.repository.ChefCuisinierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ChefCuisinierService implements IChefCuisinierService {

    private final ChefCuisinierRepository chefCuisinierRepository;

    @Override
    public ChefCuisinier saveChefCuisinier(ChefCuisinier chefCuisinier) {
        return chefCuisinierRepository.save(chefCuisinier);
    }

    @Override
    public Optional<ChefCuisinier> getChefCuisinierById(Long id) {
        return chefCuisinierRepository.findById(id);
    }

    @Override
    public List<ChefCuisinier> getAllChefsCuisiniers() {
        return chefCuisinierRepository.findAll();
    }

    @Override
    public void deleteChefCuisinier(Long id) {
        chefCuisinierRepository.deleteById(id);
    }
}
