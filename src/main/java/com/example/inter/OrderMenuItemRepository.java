package com.example.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.OrderMenuItem;

@Repository
public interface OrderMenuItemRepository extends JpaRepository<OrderMenuItem, Integer>{
	OrderMenuItem findByOrderMenuItemId(Integer orderMenuItemId);
}
