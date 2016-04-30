package BusinessDelegator;

import java.util.List;

import services.interfaces.StationServicesRemote;
import ServiceLocator.ServiceLocator;
import entities.Station;

public class StationDelegate {

	public static final String jndiName = "clicandgo-ejb/StationServices!services.interfaces.StationServicesRemote";

	public static StationServicesRemote getProxy() {
		return (StationServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static Boolean DoaddStation(Station station) {
		return getProxy().addStation(station);
	}

	public static Boolean doUpdateStation(Station station) {
		return getProxy().updateStation(station);
	}

	public static Station doFindStationById(Integer Id) {

		return getProxy().findStationById(Id);
	}

	public static Boolean doDeleteStation(Station station) {
		return getProxy().deleteStation(station);
	}

	public static List<Station> doFindAllStations() {
		return getProxy().findAllStations();
	}
    public static 	Boolean doDeleteStationById(Integer Id){
    	return getProxy().deleteStationById(Id);
    }
    
    public static Station doFindStationByReference(int ref)
    {
    	return getProxy().findStationByStationByReference(ref);
    	
    }
    public static Station findStationByStationName(String name)
    {
    	return getProxy().findStationByStationName(name);
    	
    }
}
