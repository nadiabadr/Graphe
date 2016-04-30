package BusinessDelegator;


import entities.Place;
import services.interfaces.PlaceServicesRemote;
import ServiceLocator.ServiceLocator;

public class PlaceServicesDelegate {
	public static final String jndiName = "/clicandgo-ejb/PlaceServices!services.interfaces.PlaceServicesRemote";

	public static PlaceServicesRemote getProxy() {
		return (PlaceServicesRemote) ServiceLocator.getInstance()
				.getProxy(jndiName);
	}
	public static Boolean doAddPlace(Place place){
		return getProxy().addPlace(place);
	}
	
	
	public static Boolean doAssignPlaceToStation(Place place, Integer stationId){
		return getProxy().assignPlaceToStation(place, stationId);
	}
}
