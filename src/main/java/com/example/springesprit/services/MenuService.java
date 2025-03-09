package com.example.springesprit.services;

import com.example.springesprit.entity.Menu;
import com.example.springesprit.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MenuService implements IMenuService {

    private final MenuRepository menuRepository;

    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu updateMenu(Long id, Menu menu) {
        menu.setIdMenu(id); // S'assurer que l'ID reste le même
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public List<Menu> addMenus(List<Menu> menus) {
        return menuRepository.saveAll(menus);
    }

    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu); // Correction ici !
    }
}
