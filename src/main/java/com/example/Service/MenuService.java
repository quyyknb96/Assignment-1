package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Menu;
import com.example.inter.MenuRepository;

@Service
public class MenuService {

	private static final Logger log = LoggerFactory.getLogger(MenuService.class);
	
	@Autowired
	private MenuRepository menuRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table Menu");
		menuRepository.deleteAllInBatch();
		Menu menu1 = new Menu("01/01/2108");
		Menu menu2 = new Menu("31/12/2018");
		Menu menu3 = new Menu("01/01/2020");
		ArrayList<Menu> list_Menu = new ArrayList<>();
		list_Menu.add(menu1);
		list_Menu.add(menu2);
		list_Menu.add(menu3);
		//Insert
		menuRepository.save(list_Menu);
		log.error("Insert OK");
		//Update
		Menu menu = menuRepository.findByMenuId(1);
		menu.setMenuDate("01/01/2018");
		menuRepository.save(menu);
		log.error("Update OK");
		//Select
		menuRepository.findByMenuId(2);
		log.error("Select OK");
		//Delete
		menuRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");
	}
}
