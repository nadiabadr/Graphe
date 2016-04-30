package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import BusinessDelegator.TicketServicesDelegate;
import entities.Ticket;

public class TicketTableModel extends AbstractTableModel {

	List<Ticket> tickets;
	String[] entete = { "ticketId", "price", "state", "MeanOfTransport", "User" };

	public TicketTableModel(int userId) {
		tickets = TicketServicesDelegate.doFindAllTicketsByUserId(userId);
	}

	public TicketTableModel() {
		tickets = TicketServicesDelegate.doFindAllTickets();
	}

	@Override
	public int getRowCount() {
		return tickets.size();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: {
			return tickets.get(rowIndex).getTicketId();
		}
		case 1: {
			return tickets.get(rowIndex).getPrice();
		}
		case 2: {
			return tickets.get(rowIndex).getState();

		}
		case 3: {
//			return tickets.get(rowIndex).getMeanOfTransport()
//					.getRegistrationNumber();
		}
		case 4: {
			return tickets.get(rowIndex).getUser().getUserId();

		}
		default:
			throw new IllegalArgumentException();

		}
	}

	@Override
	public String getColumnName(int column) {

		return entete[column];

	}

	public List<Ticket> searchTickets(int userId) {

		List<Ticket> tickets = TicketServicesDelegate
				.doFindAllTicketsByUserId(userId);
		List<Ticket> searchTickets = new ArrayList<>();
		List<Ticket> resultList = new ArrayList<>();

		return searchTickets;
	}

}