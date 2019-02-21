package com.ticket.service.dto;

public class ReservedSeatsFactory {
	
	public static Reservation getReservedSeats(Reservation reserv)
        {
            if(reserv instanceof ReservedSeats)
            {
                
                return new ReservedSeats();
            }
            return null;
        }

}
