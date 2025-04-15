package com.example.springesprit.services;

import com.example.springesprit.entity.ChefCuisinier;
import com.example.springesprit.entity.Menu;
import com.example.springesprit.entity.Restaurant;
import com.example.springesprit.entity.TypeChef;
import com.example.springesprit.repository.ChefCuisinierRepository;
import com.example.springesprit.repository.MenuRepository;
import com.example.springesprit.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class ChefCuisinierService implements IChefCuisinierService {

    private final ChefCuisinierRepository chefCuisinierRepository;
    private final MenuRepository menuRepository;

    @Override
    public ChefCuisinier saveChefCuisinier(ChefCuisinier chefCuisinier) {
        return chefCuisinierRepository.save(chefCuisinier);
    }

    @Override
    public Optional<ChefCuisinier> getChefCuisinierById(Long id) {
        return chefCuisinierRepository.findById(id);
    }

    @Override
    public List<ChefCuisinier> getAllChefsCuisiniers() {
        return chefCuisinierRepository.findAll();
    }

    @Override
    public void deleteChefCuisinier(Long id) {
        chefCuisinierRepository.deleteById(id);
    }

    @Override
    public ChefCuisinier affecterChefCuisinierAMenu(Long idChefCuisinier, Long idMenu) {
        Menu menu = menuRepository.findById(idMenu).orElse(null);
        ChefCuisinier chefCuisinier = chefCuisinierRepository.findById(idChefCuisinier).orElse(null);

        List<Menu> menus = new ArrayList<>();

        if(chefCuisinier!=null &&  chefCuisinier.getMenus()!=null){
            menus = chefCuisinier.getMenus();
        }

        menus.add(menu);

        chefCuisinier.setMenus(menus);

        chefCuisinierRepository.save(chefCuisinier);

        return chefCuisinier;
    }

    @Override
    public ChefCuisinier desaffecterChefCuisinierDuMenu(Long idMenu, Long idChefCuisinier) {
        Menu menu = menuRepository.findById(idMenu).orElse(null);
        ChefCuisinier chefCuisinier = chefCuisinierRepository.findById(idChefCuisinier).orElse(null);

        List<Menu> menus  = new ArrayList<>();

        if(chefCuisinier!=null && chefCuisinier.getMenus()!=null){
            menus = chefCuisinier.getMenus();
        }

        menus.remove(menu);

        chefCuisinier.setMenus(menus);

        chefCuisinierRepository.save(chefCuisinier);

        return chefCuisinier;
    }

        @Override
    public List<ChefCuisinier> listChefCuisinierByTypeChefAndRestaurant(TypeChef typeChef, String nomRestaurant) {
        return chefCuisinierRepository.findAll().stream()
                .filter(chef -> chef.getTypeChef() == typeChef)
                .filter(chef -> chef.getEtoiles() == 1)
                .filter(chef -> chef.getRestaurant().getNom().equalsIgnoreCase(nomRestaurant))
                .collect(Collectors.toList());
    }
}
