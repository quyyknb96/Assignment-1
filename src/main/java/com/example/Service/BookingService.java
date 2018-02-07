package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Booking;
import com.example.inter.BookingRepository;
import com.example.inter.CustomerRepository;
import com.example.inter.TableRepository;

@Service
public class BookingService {

	private static final Logger log = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private TableRepository tableRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table Booking");
		bookingRepository.deleteAllInBatch();
		Booking booking1 = new Booking(customerRepository.findByCustomerId(1), tableRepository.findByTableNumber(1), "01/01/2018", 10);
		Booking booking2 = new Booking(customerRepository.findByCustomerId(1), tableRepository.findByTableNumber(3), "31/12/2018", 20);
		Booking booking3 = new Booking(customerRepository.findByCustomerId(3), tableRepository.findByTableNumber(3), "01/01/2018", 30);
		ArrayList<Booking> list_Booking = new ArrayList<>();
		list_Booking.add(booking1);
		list_Booking.add(booking2);
		list_Booking.add(booking3);
		//Insert
		bookingRepository.save(list_Booking);
		log.error("Insert OK");
		//Update
		Booking booking = bookingRepository.findByBookingId(3);
		booking.setDateOfBooking("10/10/2018");
		booking.setTables(tableRepository.findByTableNumber(1));
		bookingRepository.save(booking);
		log.error("Update OK");
		//Select
		bookingRepository.findByBookingId(2);
		log.error("Select OK");
		//Delete
		bookingRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");

	}
}
