package com.example.springesprit.repository;

import com.example.springesprit.entity.ChaineRestauration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChaineRestaurationRepository extends JpaRepository<ChaineRestauration, Long> {
    ChaineRestauration findByLibelle(String libelleChaine);
}
