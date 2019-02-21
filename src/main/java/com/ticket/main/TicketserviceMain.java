package com.ticket.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ticket.service.TicketService;
import com.ticket.service.TicketServiceImpl;
import com.ticket.service.dto.SeatsOnHold;

public class TicketserviceMain {

	public static void main(String a[]) {
		TicketService ticketService = new TicketServiceImpl();
		try (Scanner scanner = new Scanner(System.in)) {
			bookTickets(scanner, ticketService);
		}
	}

	private static void bookTickets(Scanner scanner, TicketService ticketService) {
		switch (showOptions(scanner)) {
		case 1:
			System.out.println("Total Seats Available " + getAvailableSeats(ticketService));
			bookTickets(scanner, ticketService);
			break;
		case 2:
			getAvailableSeats(ticketService);
			System.out.println("Please Enter your email?");
			String email = scanner.next();
			System.out.println(" Please Enter number of seats?");
			int seats = 0;
			boolean seatSelected = false;
			do {
				try {
					seats = scanner.nextInt();
					if (seats <= 0)
						throw new InputMismatchException();
					seatSelected = true;
				} catch (InputMismatchException e) {
					System.out.print("Invalid input for number seats.");
					System.out.println("Enter number of seats?");
					seatSelected = false;
				}
			} while (!seatSelected);
			SeatsOnHold seatHold = ticketService.findAndHoldSeats(seats, email);
			if (seatHold != null) {
				System.out.println(
						"You have selected " + seatHold.getNumOfSeatsOnHold() + ". Press 'y' to continue 'n' to exit?");
				String confirmation = scanner.next();
				if (confirmation.equalsIgnoreCase("y")) {
					String reservedId = ticketService.reserveSeats(seatHold.getId(), seatHold.getCustomerEmail());
					if (reservedId == null) {
						System.out.println("Session expired. Thank you visit again.");
						bookTickets(scanner, ticketService);
					} else {
						System.out.println("Your tickets were reserved. Following is your reference Id " + reservedId);
						bookTickets(scanner, ticketService);
					}
				} else {
					System.out.println("Thank you, visit again..");
					bookTickets(scanner, ticketService);
				}
			} else {
				bookTickets(scanner, ticketService);
			}
			break;
		}
	}

	private static int showOptions(Scanner scanner) {
		boolean availableOptionSelected = false;
		int option = -1;
		do {
			Options();
			try {
				option = scanner.nextInt();
				availableOptionSelected = true;
				if (option <= 0 && option > 2)
					throw new InputMismatchException();
			} catch (InputMismatchException e) {
				System.out.println(" please Enter a valid option..");
				availableOptionSelected = false;
			}
		} while (!availableOptionSelected);
		return option;
	}

	private static void Options() {
		System.out.println("********************\n Welcome to our Travelservice \n******************** ");
		System.out.println("Select the option, 1 or 2 :\n 1. Available Seats\n 2. Book Seats\"");
		
	}
	
	private static int getAvailableSeats(TicketService ticketService) {
		int totalSeats = ticketService.numSeatsAvailable();
		if (totalSeats <= 0) {
			System.out.println(" we are sory. No seats available, Thank you, visit again.");
			System.exit(0);
		}
		return totalSeats;
	}

}
