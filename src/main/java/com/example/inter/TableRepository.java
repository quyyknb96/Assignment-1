package com.example.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Tables;

@Repository
public interface TableRepository extends JpaRepository<Tables, Integer> {
	Tables findByTableNumber(Integer tableNumber);
}
