package com.ticket.service.dto;

import java.io.Serializable;

public class ReservedSeats implements Serializable ,Reservation {

	private long reservedId;
	
	private String customerEmail;
	
	private int numOfSeats;

	public long getReservedId() {
		return reservedId;
	}

	public void setReservedId(long reservedId) {
		this.reservedId = reservedId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + numOfSeats;
		result = prime * result + (int) (reservedId ^ (reservedId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ReservedSeats)) {
			return false;
		}
		ReservedSeats other = (ReservedSeats) obj;
		if (customerEmail == null) {
			if (other.customerEmail != null) {
				return false;
			}
		} else if (!customerEmail.equals(other.customerEmail)) {
			return false;
		}
		if (numOfSeats != other.numOfSeats) {
			return false;
		}
		if (reservedId != other.reservedId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Reserved [reservedId=" + reservedId + ", customerEmail=" + customerEmail + ", numOfSeats=" + numOfSeats
				+ "]";
	}
        
        
        @Override
        public Boolean isReserved()
        {
            return null;
        }
        
}
