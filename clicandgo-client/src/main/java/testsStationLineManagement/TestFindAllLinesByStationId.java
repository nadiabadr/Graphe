package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;

public class TestFindAllLinesByStationId {
	public static void main(String[] args) {
		System.out.println(StationLineManagementDelegate
				.doFindAllLinesByStationId(1));
	}

}
