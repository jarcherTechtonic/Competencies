package com.example.chezmoose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> addIngredients(@RequestBody List<Ingredient> ingredients) {
        List<Ingredient> newIngredients = new ArrayList<>();

        for (Ingredient ingredient : ingredients) {
            Ingredient savedIngredients = ingredientRepository.save(ingredient);
            newIngredients.add(savedIngredients);
        }

        URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .buildAndExpand(newIngredients).toUri();

        return ResponseEntity.created(location).body(newIngredients);
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @GetMapping("/ingredient/{id}")
    public Ingredient getById(@PathVariable("id") Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find Ingredient with that id"));
    }

    @PutMapping("/ingredient/{id}")
    Ingredient replaceMeal(@RequestBody Ingredient updatedIngredient, @PathVariable Long id) {
        return ingredientRepository.findById(id).map(ingredient -> {

           ingredient.setMealId(updatedIngredient.getMealId());
           ingredient.setName(updatedIngredient.getName());
           return ingredientRepository.save(ingredient);

        })
        .orElseThrow(RuntimeException::new);
    }

    @Transactional
    @DeleteMapping("ingredient/name/{name}")
    public ResponseEntity deleteIngredient(@PathVariable("name") String name) {
        Optional<Ingredient> ingredient = ingredientRepository.findIngredientByName(name);

        if(ingredient.isPresent()) {
            ingredientRepository.delete(ingredient.get());
            return ResponseEntity.ok("Ingredient " + name + " deleted");
        }

        return ResponseEntity.notFound().build();
    }

    @Transactional
    @DeleteMapping("ingredient/id/{id}")
    public ResponseEntity deleteIngredientById(@PathVariable("id") Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);

        if(ingredient.isPresent()) {
            ingredientRepository.deleteById(id);
            return ResponseEntity.ok("Ingredient with id " + id + " deleted");
        }

        return ResponseEntity.notFound().build();
    }
}

