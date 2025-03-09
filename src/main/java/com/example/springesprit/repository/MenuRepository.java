package com.example.springesprit.repository;

import com.example.springesprit.entity.Menu;
import com.example.springesprit.entity.TypeComposant;
import com.example.springesprit.entity.TypeMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository <Menu, Long> {
    List<Menu> findByTypeMenuAndPrixTotalGreaterThan(TypeMenu typeMenu, double montant);
    @Query("SELECT m FROM Menu m ORDER BY m.typeMenu, m.prixTotal")
    List<Menu> findByTypeMenuOrderByPrixTotal();









}
