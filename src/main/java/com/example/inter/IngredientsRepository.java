package com.example.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Ingredients;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {
	Ingredients findByIngredientId(Integer ingredientId);
}
