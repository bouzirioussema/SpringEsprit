package com.example.springesprit.services;

import com.example.springesprit.entity.ChaineRestauration;
import com.example.springesprit.repository.ChaineRestaurationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ChaineRestaurationService implements IChaineRestaurationService {

    private final ChaineRestaurationRepository chaineRestaurationRepository;

    @Override
    public ChaineRestauration saveChaineRestauration(ChaineRestauration chaineRestauration) {
        return chaineRestaurationRepository.save(chaineRestauration);
    }

    @Override
    public Optional<ChaineRestauration> getChaineRestaurationById(Long id) {
        return chaineRestaurationRepository.findById(id);
    }

    @Override
    public List<ChaineRestauration> getAllChainesRestauration() {
        return chaineRestaurationRepository.findAll();
    }

    @Override
    public void deleteChaineRestauration(Long id) {
        chaineRestaurationRepository.deleteById(id);
    }
}
