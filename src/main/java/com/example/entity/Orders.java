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
 * Orders generated by hbm2java
 */
@Entity
@Table(name = "orders", catalog = "restaurantconceptual")
public class Orders implements java.io.Serializable {

	private Integer orderId;
	private Staff staff;
	private Tables tables;
	private String orderDateTime;
	private Set<OrderMenuItem> orderMenuItems = new HashSet<OrderMenuItem>(0);

	public Orders() {
	}

	public Orders(Staff staff, Tables tables, String orderDateTime) {
		this.staff = staff;
		this.tables = tables;
		this.orderDateTime = orderDateTime;
	}

	public Orders(Staff staff, Tables tables, String orderDateTime, Set<OrderMenuItem> orderMenuItems) {
		this.staff = staff;
		this.tables = tables;
		this.orderDateTime = orderDateTime;
		this.orderMenuItems = orderMenuItems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "order_id", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id", nullable = false)
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "table_number", nullable = false)
	public Tables getTables() {
		return this.tables;
	}

	public void setTables(Tables tables) {
		this.tables = tables;
	}

	@Column(name = "order_date_time", nullable = false, length = 100)
	public String getOrderDateTime() {
		return this.orderDateTime;
	}

	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<OrderMenuItem> getOrderMenuItems() {
		return this.orderMenuItems;
	}

	public void setOrderMenuItems(Set<OrderMenuItem> orderMenuItems) {
		this.orderMenuItems = orderMenuItems;
	}

}
