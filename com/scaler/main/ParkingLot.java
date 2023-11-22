package com.scaler.main;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scaler.modal.*;
import com.scaler.modal.enums.PaymentMode;
import com.scaler.modal.enums.PaymentStatus;
import com.scaler.modal.enums.VechileType;

public class ParkingLot {
	private static Long vechileId = (long) 1;
	private static Long ticketId = (long) 1;
	private static Long recepitId = (long) 1;
	
	private int capacity;
	private List<Vechile> parkedVechileList = new ArrayList<>();
	private Map<Long,Ticket> ticketMap = new HashMap();
	
	
	public ParkingLot(int capacity) {
		
		this.capacity = capacity;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("running");
		//create parking lot with a capacity of 100
		ParkingLot parkingLot = new ParkingLot(100);
		
		
		// vechile creation
		Vechile vechile1 = new Vechile();
		vechile1.setId(vechileId++);
		vechile1.setVechileNumber("UP14-7354");
		vechile1.setVechileType(VechileType.TWO_WHEELER);
		System.out.println(vechile1);
		
		// park vechile and generate ticket
		Ticket ticket1 = parkingLot.parkVechile(vechile1);		// method call
		System.out.println(ticket1);
		parkingLot.ticketMap.put(ticket1.getTicketID(), ticket1);
		
		
		// vechile creation
		Vechile vechile2 = new Vechile();
		vechile2.setId(vechileId++);
		vechile2.setVechileNumber("UP78-8976");
		vechile2.setVechileType(VechileType.FOUR_WHEELER);
		System.out.println(vechile2);
		
		// park vechile and generate ticket
		Ticket ticket2 = parkingLot.parkVechile(vechile2);	// method call
		System.out.println(ticket2);
		parkingLot.ticketMap.put(ticket2.getTicketID(), ticket2);
		
				
		
		// Exit Vechile
		parkingLot.exitVechile(ticket1.getTicketID());   //method call
		
	}
	
	private void exitVechile(Long ticketID) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketMap.get(ticketID);
		
		int charge = calculateAmount(ticket.getTicketID());
		System.out.println(charge);
		
		PaymentReceipt paymentReceipt = new PaymentReceipt();
		paymentReceipt.setPaymentReceiptId(recepitId++);
		paymentReceipt.setAmount(charge);
		paymentReceipt.setPaymentMode(PaymentMode.UPI);
		paymentReceipt.setPaymentStatus(PaymentStatus.SUCCESS);
		System.out.println(paymentReceipt);
		if(paymentReceipt.getPaymentStatus() == PaymentStatus.SUCCESS)
			parkedVechileList.remove(ticket.getVechile());
		
	}
	private int calculateAmount(Long ticketID) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketMap.get(ticketID);
		Vechile vechile = ticket.getVechile();
		
		LocalDateTime entryTime = ticket.getEntryTime();
		LocalDateTime exitTime = LocalDateTime.now();
		Duration timeDifference = Duration.between(entryTime, exitTime);
		long hours = timeDifference.toHours();
	    long minutes = timeDifference.toMinutes() % 60;
	    if(minutes > 0)	hours++;
	    System.out.println(hours);
		int amount = 0;
		if(vechile.getVechileType() == VechileType.TWO_WHEELER) {
			amount += (hours * 20);
		}
		else {
			amount += (hours * 40);
		}
		return amount;
	}
	private Ticket parkVechile(Vechile vechile) {
		if(capacity <= parkedVechileList.size()) {	
			System.out.println(" Parking is full ");	// error handling
			return null;
		}
		parkedVechileList.add(vechile); 
		Ticket ticket = generateTicket(vechile);
		return ticket;
	}
	private Ticket generateTicket(Vechile vechile) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket();
		ticket.setTicketID(ticketId++);
		ticket.setVechile(vechile);
		//ticket.setEntryTime(LocalDateTime.now());
		
		
		LocalDate date = LocalDate.of(2023, 10, 2); 
		LocalTime time = LocalTime.of(10, 20); 
	    LocalDateTime localdatetime = LocalDateTime.of(date, time);
		ticket.setEntryTime(localdatetime);
		return ticket;
	}

}
