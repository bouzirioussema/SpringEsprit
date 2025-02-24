package com.example.springesprit.repository;

import com.example.springesprit.entity.Client;
import com.example.springesprit.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    List<Commande> findByClientIdClient(Long client_idClient) ;
    List<Commande> findByClientIdClientAndDateCommandeBetween (Long clientId, LocalDate startDate, LocalDate endDate);
    //List<Commande> findByDateCommandeBetweenOrderBytotalCommandeAndNoteAsc(LocalDate startDate, LocalDate endDate);

    List<Commande> findByDateCommandeBetweenOrderByTotalCommandeDescNoteAsc(
            LocalDate startDate ,
            LocalDate endDate
    );

}
