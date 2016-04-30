package testsTickets;

import javax.naming.NamingException;

import BusinessDelegator.TicketServicesDelegate;

public class FindAllTicketsTest {

public static void main(String[] args) throws NamingException {
		

		System.out.println(TicketServicesDelegate.doFindAllTickets());

		
	}
}
