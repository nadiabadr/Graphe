package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;
import entities.Station;

public class TestAntecedentInTheSameLine {
	public static void main(String[] args) {
		Station station = new Station();
		station.setStationId(2);
		Station station1 = new Station();
		station1.setStationId(5);
		System.out.println(StationLineManagementDelegate
				.doAntecedentInTheSameLine(station, station1));
	}

}
