package testsTickets;

import BusinessDelegator.TicketServicesDelegate;
import entities.Ticket;

public class addTicketTest {
	public static void main(String[] args) {

		Ticket ticket = new Ticket();
		
		ticket.setPrice(120D);
		ticket.setTicketId(1);
	TicketServicesDelegate.doaddTicket(ticket);
	
		Ticket ticket2 = new Ticket();
		ticket2.setPrice(122D);
		ticket2.setTicketId(2);
	TicketServicesDelegate.doaddTicket(ticket2);
			


	

	}
}
