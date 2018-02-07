package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.IngredientType;
import com.example.inter.IngredientTypeRepository;


@Service
public class IngredientTypeService {
	
	private static final Logger log = LoggerFactory.getLogger(IngredientTypeService.class);
	
	@Autowired
	private IngredientTypeRepository ingredientTypeRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table IngredientType");
		ingredientTypeRepository.deleteAllInBatch();
		IngredientType ingredientType1 = new IngredientType("Dong vat an co");
		IngredientType ingredientType2 = new IngredientType("Thuc vat");
		IngredientType ingredientType3 = new IngredientType("Huu co");
		ArrayList<IngredientType> list_IngredientType = new ArrayList<>();
		list_IngredientType.add(ingredientType1);
		list_IngredientType.add(ingredientType2);
		list_IngredientType.add(ingredientType3);
		//Insert
		ingredientTypeRepository.save(list_IngredientType);
		log.error("Insert OK");
		//Update
		IngredientType ingredientType = ingredientTypeRepository.findByIngredientTypeCode(1);
		ingredientType.setIngredientTypeDecscription("Dong vat");
		ingredientTypeRepository.save(ingredientType);
		log.error("Update OK");
		//Select
		ingredientTypeRepository.findByIngredientTypeCode(2);
		log.error("Select OK");
		//Delete
		ingredientTypeRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");
	}
}
