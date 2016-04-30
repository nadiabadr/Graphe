package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;
import entities.Station;

public class TestAssignNewStationToLine {

	public static void main(String[] args) {

		Station newStation = new Station();
		newStation.setStationId(13);
		newStation.setName("Menzeh 5");
		newStation.setReference(11);
		newStation.setX(154);
		newStation.setY(154);
		;

		System.out.println(StationLineManagementDelegate
				.doAssignNewStationToLine(newStation, 5, 4, 2, 2));
	}
}
