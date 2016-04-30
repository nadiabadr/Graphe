package testsPlace;

import BusinessDelegator.PlaceServicesDelegate;

import entities.Place;


public class TestAjouterPlace {

	public static void main(String[] args) {

		Place place = new Place();
		
		place.setPlaceId(1);;
		place.setName("blasa");
	
	PlaceServicesDelegate.doAddPlace(place);
	
		


	

	}
	
}
