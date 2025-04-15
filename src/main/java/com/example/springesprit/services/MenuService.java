package com.example.springesprit.services;

import com.example.springesprit.entity.Composant;
import com.example.springesprit.entity.Menu;
import com.example.springesprit.entity.Restaurant;
import com.example.springesprit.repository.ComposantRepository;
import com.example.springesprit.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class MenuService implements IMenuService {

    private final MenuRepository menuRepository;
    private final ComposantRepository composantRepository;

    @Override
    public Restaurant ajoutRestaurantEtMenuAssocies(Restaurant restaurant) {
        return null;
    }

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

    public Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu) {
        Menu menu = menuRepository.findById(idMenu)
                .orElseThrow(() -> new RuntimeException("Menu non trouvé avec l'id: " + idMenu));

        // Ajouter les composants au menu
        menu.getComposants().addAll(composants);

        // Calculer le prix total
        float prixTotal = (float) menu.getComposants().stream()
                .mapToDouble(Composant::getPrix)
                .sum();

        // Vérifier si le prix total ne dépasse pas 20 dinars
        if (prixTotal > 20) {
            return null ;
         }

        composantRepository.saveAll(composants);

        // Mettre à jour le prix du menu
        menu.setPrixTotal(prixTotal);

        // Sauvegarder les modifications
        return menuRepository.save(menu);
    }
}
