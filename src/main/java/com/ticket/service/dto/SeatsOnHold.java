package com.ticket.service.dto;

import java.io.Serializable;
import java.util.Date;

public class SeatsOnHold implements Serializable{

	private long id;

	private int numOfSeatsOnHold;

	private String customerEmail;
	
	private Date expiryDate;
	
	public SeatsOnHold(long id, int numOfSeatsOnHold, String customerEmail, Date expiryDate) {
		super();
		this.id = id;
		this.numOfSeatsOnHold = numOfSeatsOnHold;
		this.customerEmail = customerEmail;
		this.expiryDate = expiryDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumOfSeatsOnHold() {
		return numOfSeatsOnHold;
	}

	public void setNumOfSeatsOnHold(int numOfSeatsOnHold) {
		this.numOfSeatsOnHold = numOfSeatsOnHold;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + numOfSeatsOnHold;
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
		if (!(obj instanceof SeatsOnHold)) {
			return false;
		}
		SeatsOnHold other = (SeatsOnHold) obj;
		if (customerEmail == null) {
			if (other.customerEmail != null) {
				return false;
			}
		} else if (!customerEmail.equals(other.customerEmail)) {
			return false;
		}
		if (expiryDate == null) {
			if (other.expiryDate != null) {
				return false;
			}
		} else if (!expiryDate.equals(other.expiryDate)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (numOfSeatsOnHold != other.numOfSeatsOnHold) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SeatHold [id=" + id + ", numOfSeatsOnHold=" + numOfSeatsOnHold + ", customerEmail=" + customerEmail
				+ ", expiryDate=" + expiryDate + "]";
	}

	
	
}
