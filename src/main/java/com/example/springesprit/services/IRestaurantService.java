package com.example.springesprit.services;

import com.example.springesprit.entity.Restaurant;

import java.util.List;

public interface IRestaurantService {
    Restaurant saveRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(Long id);
    List<Restaurant> getAllRestaurants();
    Restaurant updateRestaurant(Long id, Restaurant restaurant);
    void deleteRestaurant(Long id);
}
