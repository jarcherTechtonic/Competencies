package com.example.chezmoose;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByMealId(Long id);
    Optional<Ingredient> findIngredientByName(String name);
}
