package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;
import entities.Station;

public class TestFindStationLineOfOneStationInTheSameLineOfAnotherStation {
	public static void main(String[] args) {

		Station station = new Station();
		station.setStationId(1);
		Station station1 = new Station();
		station1.setStationId(2);
		System.out.println(StationLineManagementDelegate
				.doFindStationLineOfOneStationInTheSameLineOfAnotherStation(
						station, station1));
	}

}
