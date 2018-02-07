package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Tables;
import com.example.inter.TableRepository;

@Service
public class TableService{

	private static final Logger log = LoggerFactory.getLogger(TableService.class);
	
	@Autowired
	private TableRepository tableRepository;

	public void run() {
		log.error("=======================================");
		log.error("Table Table");
		tableRepository.deleteAllInBatch();
		Tables table1 = new Tables("Le tan");
		Tables table2 = new Tables("Tiep vien");
		Tables table3 = new Tables("Thu ngannnn");
		ArrayList<Tables> list_Table = new ArrayList<>();
		list_Table.add(table1);
		list_Table.add(table2);
		list_Table.add(table3);
		//Insert
		tableRepository.save(list_Table);
		log.error("Insert OK");
		//Update
		Tables table = tableRepository.findByTableNumber(3);
		table.setTableDetails("Thu ngan");
		tableRepository.save(table);
		log.error("Update OK");
		//Select
		tableRepository.findByTableNumber(2);
		log.error("Select OK");
		//Delete
		tableRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");
	}

}
