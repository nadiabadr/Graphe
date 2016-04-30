package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import BusinessDelegator.MeansOfTransportDelegate;
import entities.MeanOfTransport;

public class MeanOfTransportModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<MeanOfTransport> meanOfTransports;
	String[] entete = { "Registration Number", "Number of wagons", "Capacity",
			"Line" };

	public MeanOfTransportModel(String registrationNumber) {
		meanOfTransports = MeansOfTransportDelegate
				.doLookUpMeanOfTransport(registrationNumber);
	}

	public MeanOfTransportModel() {
		meanOfTransports = MeansOfTransportDelegate.doFindAllMeanOfTransports();
	}

	@Override
	public int getRowCount() {
		return meanOfTransports.size();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: {
			return meanOfTransports.get(rowIndex).getRegistrationNumber();
		}
		case 1: {
			return meanOfTransports.get(rowIndex).getNbOfWagons();
		}
		case 2: {
			return meanOfTransports.get(rowIndex).getCapacity();

		}
		case 3: {

			return meanOfTransports.get(rowIndex).getLine();

		}

		default:
			throw new IllegalArgumentException();

		}
	}

	@Override
	public String getColumnName(int column) {

		return entete[column];

	}

}
