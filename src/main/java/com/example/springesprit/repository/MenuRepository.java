package com.example.springesprit.repository;

import com.example.springesprit.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository <Menu, Integer> {
    List<Object> findAllById(Long idMenu);
}
