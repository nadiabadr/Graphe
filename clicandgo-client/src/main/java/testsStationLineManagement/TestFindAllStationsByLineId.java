package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;

public class TestFindAllStationsByLineId {
	public static void main(String[] args) {
		System.out.println(StationLineManagementDelegate
				.doFindAllStationsByLineId(1));
	}

}
