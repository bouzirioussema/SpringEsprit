package com.example.springesprit.repository;

import com.example.springesprit.entity.Menu;
import com.example.springesprit.entity.TypeComposant;
import com.example.springesprit.entity.TypeMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository <Menu, Long> {


    @Query("SELECT m FROM Menu m WHERE m.typeMenu = :typeMenu ORDER BY m.prixTotal ASC")
    List<Menu> findByTypeMenuAndOrderByPrixTotal(TypeMenu typeMenu);





    @Query("select m.libelleMenu from Menu m  join m.composants c where c.DetailComposant  = :typeComposant")
    List <Menu> findByTypeComposant(TypeComposant typeComposant);



    //findbylibelle
    @Query("SELECT m FROM Menu m WHERE m.libelleMenu = :libelleMenu")
    Menu findByLibelle(String libelleMenu);


    @Query("SELECT m FROM Menu m WHERE m.typeMenu = :typeMenu AND m.prixTotal > :prixTotal")
    List<Menu> findByTypeMenuAndPrixTotalGreaterThan(TypeMenu typeMenu , Float prixTotal);
}
