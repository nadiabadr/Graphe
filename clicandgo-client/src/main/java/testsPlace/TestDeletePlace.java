package testsPlace;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Place;
import services.interfaces.PlaceServicesRemote;

public class TestDeletePlace {
	static Context context;
	static PlaceServicesRemote proxy;

	public static void main(String[] args) throws NamingException {
		context = new InitialContext();
		proxy = (PlaceServicesRemote) context
				.lookup("/clicandgo-ejb/PlaceServices!services.interfaces.PlaceServicesRemote");

		Place place=proxy.findPlaceByPlaceId(1);
		System.out.println(proxy.deletePlace(place));

	}

}