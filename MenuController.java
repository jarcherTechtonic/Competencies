package com.example.chezmoose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MealRepository mealRepository;

    @GetMapping("/menus")
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @GetMapping("/menu/{id}")
    public Menu getById(@PathVariable("id") Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find menu with id " + id));
    }

    @GetMapping("/menu/{id}/meals")
    public List<Meal> getMealsFromMenu(@PathVariable("id") Long id) {
        return mealRepository.findByMenuId(id);
    }
}
