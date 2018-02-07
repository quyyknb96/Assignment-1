package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.StaffRole;
import com.example.inter.StaffRoleRepository;

@Service
public class StaffRoleService {

	private static final Logger log = LoggerFactory.getLogger(StaffRoleService.class);
	
	@Autowired
	private StaffRoleRepository staffRoleRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table StaffRole");
		staffRoleRepository.deleteAllInBatch();
		StaffRole staffRole1 = new StaffRole("Nhan vien");
		StaffRole staffRole2 = new StaffRole("Truong phonggg");
		StaffRole staffRole3 = new StaffRole("Giam doc");
		ArrayList<StaffRole> list_StaffRole = new ArrayList<>();
		list_StaffRole.add(staffRole1);
		list_StaffRole.add(staffRole2);
		list_StaffRole.add(staffRole3);
		//Insert
		staffRoleRepository.save(list_StaffRole);
		log.error("Insert OK");
		//Update
		StaffRole staffRole = staffRoleRepository.findByStaffRoleCode(2);
		staffRole.setStaffRoleDecscription("Truong phong");
		staffRoleRepository.save(staffRole);
		log.error("Update OK");
		//Select
		staffRoleRepository.findByStaffRoleCode(2);
		log.error("Select OK");
		//Delete
		staffRoleRepository.delete(1);
		log.error("Delete OK");
		log.error("=======================================");
	}
}
