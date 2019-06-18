package com.example.chezmoose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class MealController {
    @Autowired
    private MealRepository mealRepository;

    // add a new meal to chezmoose
    @PostMapping("/meal")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        Meal saved = mealRepository.save(meal);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();

        return ResponseEntity.created(location).body(saved);
    }

    // return all meals
    @GetMapping("/meals")
    public List<Meal> getAll() {

        return mealRepository.findAll();

    }

    // return meal by id
    @GetMapping("/meal/{id}")
    public Meal getById(@PathVariable("id") Long id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find meal with id " + id));
    }

    // update meal by id
    @PutMapping("/meal/{id}")
    Meal replaceMeal(@RequestBody Meal updatedMeal, @PathVariable Long id) {
        return mealRepository.findById(id).map(meal -> {

            meal.setName(updatedMeal.getName());
            meal.setDescription(updatedMeal.getDescription());
            meal.setPrice(updatedMeal.getPrice());
            return mealRepository.save(meal);

        })
        .orElseThrow(RuntimeException::new);
    }


    // delete meal by name
    @Transactional
    @DeleteMapping("/meal/name/{name}")
    public ResponseEntity deleteMeal(@PathVariable("name") String name ) {
        Optional<Meal> meal = mealRepository.findByName(name);

        if(meal.isPresent()) {
            mealRepository.delete(meal.get());
            return ResponseEntity.ok("Meal " + name + " deleted");
        }

        return ResponseEntity.notFound().build();
    }

    // delete meal by id
    @Transactional
    @DeleteMapping("/meal/id/{id}")
    public ResponseEntity deleteMealById(@PathVariable("id") Long id) {
        Optional<Meal> meal = mealRepository.findById(id);

        if(meal.isPresent()) {
            mealRepository.deleteById(id);
            return ResponseEntity.ok("Meal with id " + id + " deleted");
        }

        return ResponseEntity.notFound().build();
    }

}


