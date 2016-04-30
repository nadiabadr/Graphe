package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;

public class testFindStationByName {

	public static void main(String[] args) {
		String name = "Barcelone";
		System.out.print(StationLineManagementDelegate
				.doFindStationByName(name));

		System.out.println(StationLineManagementDelegate.doLookUpStation(name));
	}

}
