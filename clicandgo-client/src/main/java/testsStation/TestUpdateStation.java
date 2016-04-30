package testsStation;

import BusinessDelegator.StationDelegate;
import entities.Station;

public class TestUpdateStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Station st = StationDelegate.doFindStationById(1);
	st.setName("BebSadoun");
	StationDelegate.doUpdateStation(st);
		
		
		
	}

}
