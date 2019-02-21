package com.ticket.service;

import java.util.ArrayList;
import java.util.List;

import com.ticket.service.dto.ReservedSeats;
import com.ticket.service.dto.SeatsOnHold;

public class SeatsService {

	private static volatile SeatsService seatsService;
	private static final int TOTAL_NUM_OF_SEATS = 20;

	private SeatsService() {}
	
	public static SeatsService getInstance() {
		if (seatsService == null) {
			synchronized(SeatsService.class) {
			seatsService = new SeatsService();
			seatsService.setTotalNumOfSeats(TOTAL_NUM_OF_SEATS); 
		}
		}
		return seatsService;
	}
	
	private int totalNumOfSeats;

	private List<SeatsOnHold> seatsOnHoldList = new ArrayList<SeatsOnHold>();

	private List<ReservedSeats> reservedSeats = new ArrayList<ReservedSeats>();

	private void setTotalNumOfSeats(int totalNumOfSeats) {
		this.totalNumOfSeats = totalNumOfSeats;
	}
	
	public int getTotalNumOfSeats() {
		return totalNumOfSeats;
	}

	public List<SeatsOnHold> getSeatsOnHoldList() {
		return seatsOnHoldList;
	}

	public void setSeatsOnHoldList(List<SeatsOnHold> seatsOnHoldList) {
		this.seatsOnHoldList = seatsOnHoldList;
	}

	public List<ReservedSeats> getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(List<ReservedSeats> reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
}

