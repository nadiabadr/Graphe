package testsStation;

import entities.Station;
import BusinessDelegator.StationDelegate;

public class TestDeleteStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Station st= new Station();
	   st = StationDelegate.doFindStationById(1);
		System.out.print(StationDelegate.doDeleteStation(st));
	}
	

}
