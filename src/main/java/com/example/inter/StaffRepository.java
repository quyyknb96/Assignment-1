package com.example.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
	Staff findByStaffId(Integer staffId);
}
