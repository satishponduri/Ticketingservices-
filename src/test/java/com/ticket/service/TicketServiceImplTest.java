package com.ticket.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ticket.service.dto.SeatsOnHold;


public class TicketServiceImplTest {
	
	private TicketServiceImpl ticketServiceImpl;
	
	@Before
	public void setUp() {
		ticketServiceImpl = new TicketServiceImpl();
	}

	@Test
	public void testANumSeatsAvailable() {
		Assert.assertEquals(20, ticketServiceImpl.numSeatsAvailable());
	}
	
	@Test
	public void testBHoldingSeats() {
		String email = "foo@foo.com";
		int numSeats = 5;
		SeatsOnHold seatHold = ticketServiceImpl.findAndHoldSeats(numSeats, email);
		Assert.assertNotNull(seatHold);
		Assert.assertEquals(email, seatHold.getCustomerEmail());
		Assert.assertEquals(numSeats, seatHold.getNumOfSeatsOnHold());
		Assert.assertTrue(seatHold.getId() > 0);
		Assert.assertNotNull(seatHold.getExpiryDate());
	}
	
	@Test
	public void testCUnableToHoldSeats() {
		int numGreaterThanAvailableSeats = 25;
		Assert.assertNull(ticketServiceImpl.findAndHoldSeats(numGreaterThanAvailableSeats, "foo@foo.com"));
	}
	
	@Test
	public void testDReserveSeats() {
		String email = "foo@foo.com";
		int numSeats = 5;
		SeatsOnHold seatHold = ticketServiceImpl.findAndHoldSeats(numSeats, email);
		Assert.assertNotNull(ticketServiceImpl.reserveSeats(seatHold.getId(), email));
	}
	
	@Test
	public void testESeatHoldExpiry() throws InterruptedException {
		String email = "foo@foo.com";
		int numSeats = 5;
		SeatsOnHold seatHold = ticketServiceImpl.findAndHoldSeats(numSeats, email);
		Thread.sleep(4000); // Waiting to expire seats which are on hold
		Assert.assertNull(ticketServiceImpl.reserveSeats(seatHold.getId(), email));
	}
}
