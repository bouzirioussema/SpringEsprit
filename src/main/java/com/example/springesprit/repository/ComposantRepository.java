package com.example.springesprit.repository;

import com.example.springesprit.entity.Composant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposantRepository extends JpaRepository<Composant, Long> {
}
