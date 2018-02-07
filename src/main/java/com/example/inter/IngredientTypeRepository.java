package com.example.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.IngredientType;

@Repository
public interface IngredientTypeRepository extends JpaRepository<IngredientType, Integer> {
	IngredientType findByIngredientTypeCode(Integer ingredientTypeCode);
}
