package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.MenuItem;
import com.example.inter.MenuItemRepository;
import com.example.inter.MenuRepository;


@Service
public class MenuItemService {

private static final Logger log = LoggerFactory.getLogger(MenuItemService.class);
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table MenuItem");
		menuItemRepository.deleteAllInBatch();
		MenuItem menuItem1 = new MenuItem(menuRepository.findByMenuId(1), "Description1", 50000);
		MenuItem menuItem2 = new MenuItem(menuRepository.findByMenuId(1), "Description2", 75000);
		MenuItem menuItem3 = new MenuItem(menuRepository.findByMenuId(3), "Description3", 100000);
		ArrayList<MenuItem> list_menuItem = new ArrayList<>();
		list_menuItem.add(menuItem1);
		list_menuItem.add(menuItem2);
		list_menuItem.add(menuItem3);
		//Insert
		menuItemRepository.save(list_menuItem);
		log.error("Insert OK");
		//Update
		MenuItem menuItem = menuItemRepository.findByMenuItemId(3);
		menuItem.setMenuItemPrice(150000);
		menuItemRepository.save(menuItem);
		log.error("Update OK");
		//Select
		menuItemRepository.findByMenuItemId(2);
		log.error("Select OK");
		//Delete
		menuItemRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");
	}
}
