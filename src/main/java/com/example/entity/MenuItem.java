package com.example.entity;
// Generated Feb 7, 2018 12:36:06 AM by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MenuItem generated by hbm2java
 */
@Entity
@Table(name = "menu_item", catalog = "restaurantconceptual")
public class MenuItem implements java.io.Serializable {

	private Integer menuItemId;
	private Menu menu;
	private String menuItemDecscription;
	private int menuItemPrice;
	private Set<MenuItemIngredient> menuItemIngredients = new HashSet<MenuItemIngredient>(0);
	private Set<OrderMenuItem> orderMenuItems = new HashSet<OrderMenuItem>(0);

	public MenuItem() {
	}

	public MenuItem(Menu menu, String menuItemDecscription, int menuItemPrice) {
		this.menu = menu;
		this.menuItemDecscription = menuItemDecscription;
		this.menuItemPrice = menuItemPrice;
	}

	public MenuItem(Menu menu, String menuItemDecscription, int menuItemPrice,
			Set<MenuItemIngredient> menuItemIngredients, Set<OrderMenuItem> orderMenuItems) {
		this.menu = menu;
		this.menuItemDecscription = menuItemDecscription;
		this.menuItemPrice = menuItemPrice;
		this.menuItemIngredients = menuItemIngredients;
		this.orderMenuItems = orderMenuItems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "menu_item_id", unique = true, nullable = false)
	public Integer getMenuItemId() {
		return this.menuItemId;
	}

	public void setMenuItemId(Integer menuItemId) {
		this.menuItemId = menuItemId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "menu_id", nullable = false)
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Column(name = "menu_item_decscription", nullable = false, length = 100)
	public String getMenuItemDecscription() {
		return this.menuItemDecscription;
	}

	public void setMenuItemDecscription(String menuItemDecscription) {
		this.menuItemDecscription = menuItemDecscription;
	}

	@Column(name = "menu_item_price", nullable = false)
	public int getMenuItemPrice() {
		return this.menuItemPrice;
	}

	public void setMenuItemPrice(int menuItemPrice) {
		this.menuItemPrice = menuItemPrice;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menuItem")
	public Set<MenuItemIngredient> getMenuItemIngredients() {
		return this.menuItemIngredients;
	}

	public void setMenuItemIngredients(Set<MenuItemIngredient> menuItemIngredients) {
		this.menuItemIngredients = menuItemIngredients;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menuItem")
	public Set<OrderMenuItem> getOrderMenuItems() {
		return this.orderMenuItems;
	}

	public void setOrderMenuItems(Set<OrderMenuItem> orderMenuItems) {
		this.orderMenuItems = orderMenuItems;
	}

}