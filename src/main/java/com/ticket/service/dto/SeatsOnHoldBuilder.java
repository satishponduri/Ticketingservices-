package com.ticket.service.dto;

import java.util.Date;

public class SeatsOnHoldBuilder {
	
	
	private long id;

	private int numOfSeatsOnHold;

	private String customerEmail;
	
	private Date expiryDate;
	
	public SeatsOnHoldBuilder setId(long id)
    {
        this.id=id;
        return this;
    }
	public SeatsOnHoldBuilder setNumOfSeatsOnHold(int numOfSeatsOnHold)
    {
        this. numOfSeatsOnHold= numOfSeatsOnHold;
        return this;
    }
	public SeatsOnHoldBuilder setCustomerEmail(String customerEmail)
    {
        this.customerEmail=customerEmail;
        return this;
    }
	public SeatsOnHoldBuilder setexpiryDate(Date expiryDate)
    {
        this.expiryDate=expiryDate;
        return this;
    }
	
	public SeatsOnHold build()
    {
        return new SeatsOnHold (id,numOfSeatsOnHold,customerEmail,expiryDate);
    }
	
	

}
