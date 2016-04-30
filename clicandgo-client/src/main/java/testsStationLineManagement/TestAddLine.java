package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;
import entities.Line;

public class TestAddLine {
	public static void main(String[] args) {
		Line line = new Line();
		line.setName("M0");
		line.setNbStations(5);
		System.out.println(StationLineManagementDelegate.doAddLine(line));

		Line line1 = new Line();
		line1.setName("M1");
		line1.setNbStations(6);
		System.out.println(StationLineManagementDelegate.doAddLine(line1));

//		Line line2 = new Line();
//		line2.setName("M2");
//		line2.setNbStations(7);
//		System.out.println(StationLineManagementDelegate.doAddLine(line2));
//
//		Line line3 = new Line();
//		line3.setName("M3");
//		line3.setNbStations(8);
//		System.out.println(StationLineManagementDelegate.doAddLine(line3));
	}

}
