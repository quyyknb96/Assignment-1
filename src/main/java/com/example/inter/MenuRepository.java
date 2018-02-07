package com.example.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
	Menu findByMenuId(int menuId);
}
