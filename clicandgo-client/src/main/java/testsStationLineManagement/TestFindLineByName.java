package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;

public class TestFindLineByName {
	public static void main(String[] args) {
		String name = "M1";
		System.out.print(StationLineManagementDelegate.doFindLineByName(name));

		// System.out.println(LineServicesDelegate.doFindLineByName("L1"));

	}
}
