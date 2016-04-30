package testsPlace;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Place;
import services.interfaces.PlaceServicesRemote;
public class TestAddPlace {
	static Context context;
	static PlaceServicesRemote proxy;

	public static void main(String[] args) throws NamingException {
		context = new InitialContext();
		proxy = (PlaceServicesRemote) context
				.lookup("/clicandgo-ejb/PlaceServices!services.interfaces.PlaceServicesRemote");

		testUpdatePlace();
		
	}

	public static void testAddPlace() {
		Place place = new Place();
		place.setPlaceId(1);
		place.setName("ppp");
		place.setDescription("affef");
		place.setCategory("eee");
		place.setStation(null);
		proxy.addPlace(place);
		
	}
	public static void testUpdatePlace() {
		Place placeFound = proxy.findPlaceByPlaceId(1);
		placeFound.setName("new");
		proxy.updatePlace(placeFound);

	}

	public static void testDeletePlace() {
		proxy.deletePlaceByPlaceId(1);

	}

	public static void testFindPlaceByPlaceId() {
		System.out.println(proxy.findPlaceByPlaceId(1).getName());

	}

	
}
