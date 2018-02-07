package com.example.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Service.BookingService;
import com.example.Service.CustomerService;
import com.example.Service.IngredientTypeService;
import com.example.Service.IngredientsService;
import com.example.Service.MenuItemIngredientService;
import com.example.Service.MenuItemService;
import com.example.Service.MenuService;
import com.example.Service.OrderMenuItemService;
import com.example.Service.OrderService;
import com.example.Service.StaffRoleService;
import com.example.Service.StaffService;
import com.example.Service.TableService;

@Component
public class MyComponent implements CommandLineRunner {

	@Autowired
	private TableService tableService;
	
	@Autowired
	private StaffRoleService staffRoleService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private IngredientTypeService ingredientTypeService;
	
	@Autowired
	private IngredientsService ingredientsService;
	
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private MenuItemIngredientService menuItemIngredientService;
	
	@Autowired
	private OrderMenuItemService orderMenuItemService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		tableService.run();
		staffRoleService.run();
		staffService.run();
		orderService.run();
		customerService.run();
		bookingService.run();
		menuService.run();
		ingredientTypeService.run();
		ingredientsService.run();
		menuItemService.run();
		menuItemIngredientService.run();
		orderMenuItemService.run();
	}

}
