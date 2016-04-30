package testsTickets;

import javax.naming.NamingException;

import BusinessDelegator.TicketServicesDelegate;

public class FindTicketByIdTest {
	
	public static void main(String[] args) throws NamingException {
		System.out.println(TicketServicesDelegate.doFindTicketById(1).getPrice());

}

}
