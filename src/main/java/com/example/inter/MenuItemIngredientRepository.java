package com.example.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.MenuItemIngredient;

@Repository
public interface MenuItemIngredientRepository extends JpaRepository<MenuItemIngredient, Integer> {
	MenuItemIngredient findByMenuItemIngredientId(Integer menuItemIngredientId);
}
