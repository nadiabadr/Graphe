package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import BusinessDelegator.StationDelegate;
import BusinessDelegator.StationLineManagementDelegate;
import entities.Station;

public class StationTableModel extends AbstractTableModel {

	List<Station> stations;
	String[] entete = { "Name", "Reference", "Longitude", "Latitude" };

	public StationTableModel() {
		stations = StationDelegate.doFindAllStations();
	}

	public StationTableModel(String search) {
		stations = StationLineManagementDelegate.doLookUpStation(search);
	}

	@Override
	public int getRowCount() {
		return stations.size();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: {
			return stations.get(rowIndex).getName();
		}
		case 1: {
			return stations.get(rowIndex).getReference();
		}
		case 2: {
			return stations.get(rowIndex).getX();
		}
		case 3: {
			return stations.get(rowIndex).getY();
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
