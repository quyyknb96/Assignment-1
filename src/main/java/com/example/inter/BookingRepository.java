package com.example.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	Booking findByBookingId(Integer bookingId);
}
