package testsStation;

import BusinessDelegator.StationDelegate;
import entities.Station;

public class TestAddStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Station st= new Station();
		st.setName("BebAlioua");
		StationDelegate.DoaddStation(st);
		
		
	}
    
}
