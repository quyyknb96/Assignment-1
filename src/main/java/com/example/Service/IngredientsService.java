package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Ingredients;
import com.example.inter.IngredientTypeRepository;
import com.example.inter.IngredientsRepository;

@Service
public class IngredientsService {

	private static final Logger log = LoggerFactory.getLogger(IngredientsService.class);
	
	@Autowired
	private IngredientsRepository ingredientsRepository;
	
	@Autowired
	private IngredientTypeRepository ingredientTypeRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table Ingredients");
		ingredientsRepository.deleteAllInBatch();
		Ingredients ingredients1 = new Ingredients(ingredientTypeRepository.findByIngredientTypeCode(1),"Buffalo");
		Ingredients ingredients2 = new Ingredients(ingredientTypeRepository.findByIngredientTypeCode(1),"Cow");
		Ingredients ingredients3 = new Ingredients(ingredientTypeRepository.findByIngredientTypeCode(3),"Mushroommm");
		ArrayList<Ingredients> list_Ingredients = new ArrayList<>();
		list_Ingredients.add(ingredients1);
		list_Ingredients.add(ingredients2);
		list_Ingredients.add(ingredients3);
		//Insert
		ingredientsRepository.save(list_Ingredients);
		log.error("Insert OK");
		//Update
		Ingredients ingredients = ingredientsRepository.findByIngredientId(3);
		ingredients.setIngredientName("Mushroom");
		ingredientsRepository.save(ingredients);
		log.error("Update OK");
		//Select
		ingredientsRepository.findByIngredientId(2);
		log.error("Select OK");
		//Delete
		ingredientsRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");
	}
}
