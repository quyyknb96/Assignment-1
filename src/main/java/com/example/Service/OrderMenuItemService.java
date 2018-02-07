package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.OrderMenuItem;
import com.example.inter.MenuItemRepository;
import com.example.inter.OrderMenuItemRepository;
import com.example.inter.OrdersRepository;

@Service
public class OrderMenuItemService {

	private static final Logger log = LoggerFactory.getLogger(OrderMenuItemService.class);
	
	@Autowired
	private OrderMenuItemRepository orderMenuItemRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table MenuItemIngredient");
		OrderMenuItem orderMenuItem1 = new OrderMenuItem(menuItemRepository.findByMenuItemId(1), ordersRepository.findByOrderId(1), 1, "Good");
		OrderMenuItem orderMenuItem2 = new OrderMenuItem(menuItemRepository.findByMenuItemId(1), ordersRepository.findByOrderId(3), 2, "Very good");
		OrderMenuItem orderMenuItem3 = new OrderMenuItem(menuItemRepository.findByMenuItemId(3), ordersRepository.findByOrderId(1), 3, "Bad");
		ArrayList<OrderMenuItem> list_orderMenuItem = new ArrayList<>();
		list_orderMenuItem.add(orderMenuItem1);
		list_orderMenuItem.add(orderMenuItem2);
		list_orderMenuItem.add(orderMenuItem3);
		//Insert
		orderMenuItemRepository.save(list_orderMenuItem);
		log.error("Insert OK");
		//Update
		OrderMenuItem orderMenuItem = orderMenuItemRepository.findByOrderMenuItemId(3);
		orderMenuItem.setOrderMenuItemComments("Not bad");
		orderMenuItemRepository.save(orderMenuItem);
		log.error("Update OK");
		//Select
		orderMenuItemRepository.findByOrderMenuItemId(2);
		log.error("Select OK");
		//Delete
		orderMenuItemRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");
	}
}
