package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Staff;
import com.example.inter.StaffRepository;
import com.example.inter.StaffRoleRepository;

@Service
public class StaffService {

	private static final Logger log = LoggerFactory.getLogger(StaffRoleService.class);
	
	@Autowired
	private StaffRoleRepository staffRoleRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table Staff");
		staffRepository.deleteAllInBatch();
		Staff staff1 = new Staff(staffRoleRepository.findByStaffRoleCode(3)/*new StaffRole("Truong phong")*/,"Ta Ngoc","Quy");
		Staff staff2 = new Staff(staffRoleRepository.findByStaffRoleCode(2),"Ta Quang","Quyen");
		Staff staff3 = new Staff(staffRoleRepository.findByStaffRoleCode(2),"Ta Quang","Quyennn");
		ArrayList<Staff> list_Staff = new ArrayList<>();
		list_Staff.add(staff1);
		list_Staff.add(staff2);
		list_Staff.add(staff3);
		//Insert
		staffRepository.save(list_Staff);
		log.error("Insert OK");
		//Update
		Staff staff = staffRepository.findByStaffId(3);
		staff.setStaffLastName("Quyen");
		staffRepository.save(staff);
		log.error("Update OK");
		//Select
		staffRepository.findByStaffId(2);
		log.error("Select OK");
		//Delete
		staffRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");
	}
}
