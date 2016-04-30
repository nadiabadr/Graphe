package testsTickets;

import entities.Ticket;
import BusinessDelegator.TicketServicesDelegate;

public class UpdateTicketsTest {

public static void main(String[] args) {
		
		Ticket ticket = TicketServicesDelegate.doFindTicketById(2);
		ticket.setPrice(600D);
			
		System.out.println(TicketServicesDelegate.doupdateTicket(ticket));
		
	}
}
