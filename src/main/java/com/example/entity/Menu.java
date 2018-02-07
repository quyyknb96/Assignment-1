package com.example.entity;
// Generated Feb 7, 2018 12:36:06 AM by Hibernate Tools 5.2.8.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Menu generated by hbm2java
 */
@Entity
@Table(name = "menu", catalog = "restaurantconceptual")
public class Menu implements java.io.Serializable {

	private int menuId;
	private String menuDate;
	private Set<MenuItem> menuItems = new HashSet<MenuItem>(0);

	public Menu() {
	}

	public Menu(String menuDate) {
		this.menuDate = menuDate;
	}

	public Menu(String menuDate, Set<MenuItem> menuItems) {
		this.menuDate = menuDate;
		this.menuItems = menuItems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "menu_id", unique = true, nullable = false)
	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	@Column(name = "menu_date", nullable = false, length = 100)
	public String getMenuDate() {
		return this.menuDate;
	}

	public void setMenuDate(String menuDate) {
		this.menuDate = menuDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<MenuItem> getMenuItems() {
		return this.menuItems;
	}

	public void setMenuItems(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

}