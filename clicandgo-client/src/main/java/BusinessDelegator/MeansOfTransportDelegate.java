package BusinessDelegator;

import java.util.List;

import services.interfaces.MeanOfTransportServicesRemote;
import ServiceLocator.ServiceLocator;
import entities.MeanOfTransport;

public class MeansOfTransportDelegate {

	public static final String jndiName = "/clicandgo-ejb/MeanOfTransportServices!services.interfaces.MeanOfTransportServicesRemote";

	public static MeanOfTransportServicesRemote getProxy() {
		return (MeanOfTransportServicesRemote) ServiceLocator.getInstance()
				.getProxy(jndiName);
	}

	public static Boolean doAddMeanOfTransport(MeanOfTransport MeanOfTransport) {
		return getProxy().addMeanOfTransport(MeanOfTransport);

	}

	public static Boolean doAssignMeanOfTransportToLine(
			String meanId, Integer lineId) {
		return getProxy().assignMeanOfTransportToLine(meanId,
				lineId);

	}

	public static MeanOfTransport doFindMeanOfTransportById(String Id) {
		return getProxy().findMeanOfTransportById(Id);
	}

	public static List<MeanOfTransport> doFindAllMeanOfTransports() {
		return getProxy().findAllMeanOfTransports();
	}

	public static Boolean DoDeleteMeanOfTransportById(String Id) {
		return getProxy().deleteMeanOfTransportById(Id);
	}

	public static List<MeanOfTransport> doLookUpMeanOfTransport(String id) {
		return getProxy().lookUpMeanOfTransport(id);
	}
	
	public static MeanOfTransport dofindMeanOftransportByName(String name)
	{return getProxy().findMeanOfTransportByName(name);
	}
}
