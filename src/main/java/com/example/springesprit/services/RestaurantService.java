package com.example.springesprit.services;

import com.example.springesprit.entity.ChaineRestauration;
import com.example.springesprit.entity.Menu;
import com.example.springesprit.entity.Restaurant;
import com.example.springesprit.repository.ChaineRestaurationRepository;
import com.example.springesprit.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class RestaurantService implements IRestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ChaineRestaurationRepository chaineRestaurationRepository;




    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }


    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        restaurant.setIdRestaurant(id);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurant affecterRestaurantAChaineRestauration(String nomRestaurant, String libelleChaine) {
        Restaurant restaurant = restaurantRepository.findByNom(nomRestaurant);

        ChaineRestauration chaineRestauration = chaineRestaurationRepository.findByLibelle(libelleChaine);

        restaurant.setChaineRestauration(chaineRestauration);

        return restaurantRepository.save(restaurant);
    }

    public Restaurant ajoutRestaurantEtMenuAssocies(Restaurant restaurant) {
        List<Menu> menus  =  new ArrayList<>();
        for (Menu menu : restaurant.getMenus()) {

            menu.setPrixTotal((float) 0);
            menus.add(menu);

        }

        restaurant.setMenus(menus);

        restaurantRepository.save(restaurant);
        return restaurant;
    }

}
