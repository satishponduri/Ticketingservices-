package com.ticket.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ticket.service.dto.ReservedSeats;
import com.ticket.service.dto.SeatsOnHold;
import com.ticket.service.dto.SeatsOnHoldBuilder;

public class TicketServiceImpl implements TicketService {
	
	
	private Random random = new Random(1000);
    Object objreser = new Object();

/**
 * Holding seats for 5 seconds, configurable.
 */
private static final int SOLD_HOLD_TIME_IN_SECONDS = 5;

public int numSeatsAvailable() {
	removeExpiredSeats();
	int totalNumOfSeats = SeatsService.getInstance().getTotalNumOfSeats();
	List<SeatsOnHold> seatsOnHold = SeatsService.getInstance().getSeatsOnHoldList();
	for (SeatsOnHold seatHold : seatsOnHold) {
		totalNumOfSeats -= seatHold.getNumOfSeatsOnHold();
	}
	List<ReservedSeats> reservedSeats = SeatsService.getInstance().getReservedSeats();
	for (ReservedSeats reserved : reservedSeats) {
		totalNumOfSeats -= reserved.getNumOfSeats();
	}
	return totalNumOfSeats;
}

public  SeatsOnHold findAndHoldSeats(int numSeats, String customerEmail) {
	removeExpiredSeats();
            synchronized(objreser){
	int seatsAvailable = numSeatsAvailable();
	if (!(numSeats > seatsAvailable)) {
		List<SeatsOnHold> seatsOnHoldList = SeatsService.getInstance().getSeatsOnHoldList();
		SeatsOnHoldBuilder seatBuild =  new SeatsOnHoldBuilder();
		seatBuild.setId(seatsOnHoldList.size() + 1).setNumOfSeatsOnHold(numSeats).setCustomerEmail(customerEmail);
        SeatsOnHold seatHold = seatBuild.build();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, SOLD_HOLD_TIME_IN_SECONDS); 
		seatHold.setExpiryDate(cal.getTime());
		seatsOnHoldList.add(seatHold);
		System.out.println("We have kept requested number of seats on hold.");
		return seatHold;
	} else {
		System.out.println("WE are sorry, Requested number of seats are not available.");
		System.out.println("Number of seats currently available are " + seatsAvailable);
	}
    }
	return null;
}

public String reserveSeats(long seatHoldId, String customerEmail) {
	removeExpiredSeats();
	String reservedId = null;
	List<SeatsOnHold> seatsOnHold = SeatsService.getInstance().getSeatsOnHoldList();
	int indexToRemove = -1;
	for (SeatsOnHold holdedSeat : seatsOnHold) {
		if (holdedSeat.getId() == seatHoldId) {
			ReservedSeats reserved = new ReservedSeats();
			reserved.setCustomerEmail(customerEmail);
			reserved.setNumOfSeats(holdedSeat.getNumOfSeatsOnHold());
			long uniqueId = getUniqueId();
			reserved.setReservedId(uniqueId);
			reservedId = "" + getUniqueId();
			SeatsService.getInstance().getReservedSeats().add(reserved);
			indexToRemove = seatsOnHold.indexOf(holdedSeat);
		}
	}
	if (indexToRemove > -1) {
		seatsOnHold.remove(indexToRemove);
	} else {
		System.out.println(" We are sorry Session Expired. No seats are on hold.");
	}
	return reservedId;
}

private long getUniqueId() {
	long id = 0;
	do {
		id = random.nextLong();	
	} while (isExistingId(id));
	
	return id;
}

private boolean isExistingId(long id) {
	List<ReservedSeats> reservedSeats = SeatsService.getInstance().getReservedSeats();
	for (ReservedSeats reservedSeat : reservedSeats) {
		if (reservedSeat.getReservedId() == id) 
			return true;
	}
	return false;
}

private void removeExpiredSeats() {
	List<Integer> indexesToRemove = new ArrayList<Integer>();
	List<SeatsOnHold> seatsOnHold = SeatsService.getInstance().getSeatsOnHoldList();
	
	seatsOnHold.forEach((seat) -> {
		if (new Date().after(seat.getExpiryDate())) {
			indexesToRemove.add(seatsOnHold.indexOf(seat));
		}
	});
	
	indexesToRemove.forEach((index) -> {
		seatsOnHold.remove(seatsOnHold.get(index));
	});
}


}
