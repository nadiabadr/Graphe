package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;

public class TestAssignStationToLine {
	public static void main(String[] args) {

		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				1, 1, 1, 5, 5));
		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				2, 1, 2, 5, 5));

		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				3, 1, 3, 4, 4));
		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				4, 1, 4, 2, 2));

		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				4, 2, 1, 1, 1));

		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				5, 2, 2, 1, 1));

		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				5, 3, 1, 5, 5));

		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				6, 3, 2, 5, 5));

		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				7, 3, 3, 4, 4));
		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				8, 3, 4, 4, 4));
		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				9, 3, 5, 3, 3));
		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				5, 4, 1, 15, 15));
		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				12, 4, 2, 15, 15));
		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				4, 5, 1, 8, 8));
		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				10, 5, 2, 8, 8));
		System.out.println(StationLineManagementDelegate.doAssignStationToLine(
				11, 5, 3, 3, 3));

	}
}
