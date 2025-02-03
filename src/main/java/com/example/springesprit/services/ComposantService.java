package com.example.springesprit.services;

import com.example.springesprit.entity.Composant;
import com.example.springesprit.repository.ComposantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComposantService implements IComposantService {

    private final ComposantRepository composantRepository;

    public ComposantService(ComposantRepository composantRepository) {
        this.composantRepository = composantRepository;
    }

    @Override
    public Composant saveComposant(Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public Composant getComposantById(Long id) {
        return composantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Composant> getAllComposants() {
        return composantRepository.findAll();
    }

    @Override
    public Composant updateComposant(Long id, Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public void deleteComposant(Long id) {
        composantRepository.deleteById(id);
    }

    @Override
    public List<Composant> addComposants(List<Composant> composants) {
        return composantRepository.saveAll(composants);
    }
}
