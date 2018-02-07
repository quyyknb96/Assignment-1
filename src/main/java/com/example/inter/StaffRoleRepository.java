package com.example.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.StaffRole;

@Repository
public interface StaffRoleRepository extends JpaRepository<StaffRole, Integer> {
	StaffRole findByStaffRoleCode(Integer staffRoleCode);
}
