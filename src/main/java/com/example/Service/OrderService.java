package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Orders;
import com.example.inter.OrdersRepository;
import com.example.inter.StaffRepository;
import com.example.inter.TableRepository;

@Service
public class OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private TableRepository tableRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table Order");
		Orders order1 = new Orders(staffRepository.findByStaffId(1),tableRepository.findByTableNumber(1),"01/01/2018");
		Orders order2 = new Orders(staffRepository.findByStaffId(1),tableRepository.findByTableNumber(3),"01/01/2019");
		Orders order3 = new Orders(staffRepository.findByStaffId(3),tableRepository.findByTableNumber(3),"01/01/2020");
		ArrayList<Orders> list_Order = new ArrayList<>();
		list_Order.add(order1);
		list_Order.add(order2);
		list_Order.add(order3);
		//Insert
		ordersRepository.save(list_Order);
		log.error("Insert OK");
		//Update
		Orders order = ordersRepository.findByOrderId(3);
		order.setTables(tableRepository.findByTableNumber(1));
		ordersRepository.save(order);
		log.error("Update OK");
		//Select
		ordersRepository.findByOrderId(2);
		log.error("Select OK");
		//Delete
		ordersRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");
	}
}
