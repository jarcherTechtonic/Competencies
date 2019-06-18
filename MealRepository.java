package com.example.chezmoose;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByMenuId(Long id);
    Optional<Meal> findByName(String name);
}
