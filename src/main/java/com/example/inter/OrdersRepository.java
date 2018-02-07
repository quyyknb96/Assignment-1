package com.example.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	Orders findByOrderId(Integer orderId);
}
