package com.example.springesprit.services;

import com.example.springesprit.entity.Menu;
import com.example.springesprit.entity.Restaurant;

import java.util.List;

public interface IMenuService {
    Restaurant ajoutRestaurantEtMenuAssocies(Restaurant restaurant);
    Menu saveMenu(Menu menu);
    Menu getMenuById(Long id);
    List<Menu> getAllMenus();
    Menu updateMenu(Long id, Menu menu);
    void deleteMenu(Long id);
    List<Menu> addMenus(List<Menu> menus);

    Menu addMenu(Menu menu);
}
