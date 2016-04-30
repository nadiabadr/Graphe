package BusinessDelegator;

import java.util.List;

import entities.Ticket;
import ServiceLocator.ServiceLocator;
import services.interfaces.TicketsServicesRemote;

public class TicketServicesDelegate {

	public static final String jndiName = "/clicandgo-ejb/TicketsServices!services.interfaces.TicketsServicesRemote";

	public static TicketsServicesRemote getProxy() {
		return (TicketsServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static Boolean doaddTicket(Ticket ticket){
		return getProxy().addTicket(ticket);
	}
	public static Boolean doupdateTicket(Ticket ticket){
		return getProxy().updateTicket(ticket);
	}
	public static List<Ticket> doFindAllTickets() {
		return getProxy().findAllTickets();
	}
	public static Ticket doFindTicketById(Integer ticketId) {
		return getProxy().findTicketById(ticketId);
	}
	public static List<Ticket> doFindAllTicketsByUserId(Integer userId) {
		return getProxy().findAllTicketsByUserId(userId);
	}
}
