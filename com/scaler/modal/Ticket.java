package com.scaler.modal;

import java.time.LocalDateTime;

public class Ticket {
	private Long ticketID;
	private Vechile vechile;
	private LocalDateTime entryTime;
	
	public Long getTicketID() {
		return ticketID;
	}
	public Vechile getVechile() {
		return vechile;
	}
	public LocalDateTime getEntryTime() {
		return entryTime;
	}
	
	
	public void setTicketID(Long ticketID) {
		this.ticketID = ticketID;
	}
	public void setVechile(Vechile vechile) {
		this.vechile = vechile;
	}
	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}
	
	@Override
	public String toString() {
		return "Ticket [ticketID=" + ticketID + ", vechile=" + vechile + ", entryTime=" + entryTime + "]";
	}
	
	
	
	
}
