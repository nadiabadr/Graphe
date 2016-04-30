package testsPlace;

import BusinessDelegator.PlaceServicesDelegate;
import BusinessDelegator.StationDelegate;
import entities.Place;
import entities.Station;

public class TestAssignPlaceToStation {
	
	public static void main(String[] args) {
		Place place = new Place();
		place.setPlaceId(1);
//		place.setName("test");
//		PlaceServicesDelegate.doAddPlace(place);
		PlaceServicesDelegate.doAssignPlaceToStation(place, 1);

	}
}
