package com.ticket.service;

import com.ticket.service.dto.SeatsOnHold;

public interface TicketService {
	
public abstract int numSeatsAvailable();

	
public abstract	SeatsOnHold findAndHoldSeats(int numSeats, String customerEmail);

	
public abstract	String reserveSeats(long seatHoldId, String customerEmail);
}