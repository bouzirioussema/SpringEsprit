package com.example.springesprit.services;

import com.example.springesprit.entity.ChaineRestauration;

import java.util.List;
import java.util.Optional;

public interface IChaineRestaurationService {
    ChaineRestauration saveChaineRestauration(ChaineRestauration chaineRestauration);
    Optional<ChaineRestauration> getChaineRestaurationById(Long id);
    List<ChaineRestauration> getAllChainesRestauration();
    void deleteChaineRestauration(Long id);
}
