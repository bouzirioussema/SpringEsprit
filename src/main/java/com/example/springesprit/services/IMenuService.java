package com.example.springesprit.services;

import com.example.springesprit.entity.Composant;
import com.example.springesprit.entity.Menu;
import com.example.springesprit.entity.Restaurant;

import java.util.List;
import java.util.Set;

public interface IMenuService {
    Restaurant ajoutRestaurantEtMenuAssocies(Restaurant restaurant);
    Menu saveMenu(Menu menu);
    Menu getMenuById(Long id);
    List<Menu> getAllMenus();
    Menu updateMenu(Long id, Menu menu);
    void deleteMenu(Long id);
    List<Menu> addMenus(List<Menu> menus);
    Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu);
    Menu addMenu(Menu menu);
    List<Menu> listeMenuSelonTypeMenuEtprixComposantsSuperieurAUnMontant(TypeMenu typeMenu, Float prixTotal);
}
