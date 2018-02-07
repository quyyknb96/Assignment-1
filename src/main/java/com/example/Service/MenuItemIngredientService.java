package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.MenuItemIngredient;
import com.example.inter.IngredientsRepository;
import com.example.inter.MenuItemIngredientRepository;
import com.example.inter.MenuItemRepository;

@Service
public class MenuItemIngredientService {

	private static final Logger log = LoggerFactory.getLogger(MenuItemIngredientService.class);
	
	@Autowired
	private MenuItemIngredientRepository menuItemIngredientRepository;
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@Autowired
	private IngredientsRepository ingredientsRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table MenuItemIngredient");
		MenuItemIngredient menuItemIngredient1 = new MenuItemIngredient(ingredientsRepository.findByIngredientId(1), menuItemRepository.findByMenuItemId(1), 10);
		MenuItemIngredient menuItemIngredient2 = new MenuItemIngredient(ingredientsRepository.findByIngredientId(1), menuItemRepository.findByMenuItemId(3), 20);
		MenuItemIngredient menuItemIngredient3 = new MenuItemIngredient(ingredientsRepository.findByIngredientId(3), menuItemRepository.findByMenuItemId(3), 25);
		ArrayList<MenuItemIngredient> list_menuItemIngredient = new ArrayList<>();
		list_menuItemIngredient.add(menuItemIngredient1);
		list_menuItemIngredient.add(menuItemIngredient2);
		list_menuItemIngredient.add(menuItemIngredient3);
		//Insert
		menuItemIngredientRepository.save(list_menuItemIngredient);
		log.error("Insert OK");
		//Update
		MenuItemIngredient menuItemIngredient = menuItemIngredientRepository.findByMenuItemIngredientId(3);
		menuItemIngredient.setItemQuantity(35);
		menuItemIngredientRepository.save(menuItemIngredient);
		log.error("Update OK");
		//Select
		menuItemIngredientRepository.findByMenuItemIngredientId(2);
		log.error("Select OK");
		//Delete
		menuItemIngredientRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");
	}
}
