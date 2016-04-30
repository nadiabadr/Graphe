package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;
import entities.Line;
import entities.Station;

public class TestFindStationLineByLineAndStation {
	public static void main(String[] args) {
		Line line = new Line();
		line.setLineId(1);
		Station station = new Station();
		station.setStationId(2);
		System.out.println(StationLineManagementDelegate
				.doFindStationLineByLineAndStation(line, station));
	}
}
